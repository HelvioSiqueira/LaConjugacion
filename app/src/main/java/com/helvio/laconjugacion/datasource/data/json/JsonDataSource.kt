package com.helvio.laconjugacion.datasource.data.json

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsDto
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Data Source responsável por carregar dados de conjugação dos arquivos JSON nos assets.
 * Implementa operações de I/O de forma assíncrona usando coroutines.
 */
class JsonDataSource : IJsonDataSource {
    
    private val gson = Gson()
    
    /**
     * Carrega conjugações de múltiplos arquivos JSON de forma assíncrona.
     * Combina todos os verbos dos arquivos em um único ConjugationsDto.
     * 
     * @param context Contexto do Android para acessar os assets
     * @param files Lista de nomes de arquivos JSON a serem carregados
     * @return ConjugationsDto com todos os verbos dos arquivos carregados
     * @throws IOException Se houver erro ao ler os arquivos
     * @throws JsonSyntaxException Se houver erro ao fazer parse do JSON
     */
    override suspend fun loadConjugations(
        context: Context, 
        files: List<String>
    ): ConjugationsDto = withContext(Dispatchers.IO) {
        
        if (files.isEmpty()) {
            Log.w(TAG, "Lista de arquivos vazia")
            return@withContext ConjugationsDto()
        }
        
        val allVerbs = mutableListOf<VerbDto>()
        var lastConjugationsDto = ConjugationsDto()
        
        files.forEach { fileName ->
            try {
                val jsonContent = readJsonFromAsset(context, fileName)
                val conjugationsDto = parseJson(jsonContent, fileName)
                
                allVerbs.addAll(conjugationsDto.verbs)
                lastConjugationsDto = conjugationsDto
                
                Log.d(TAG, "Carregado $fileName com ${conjugationsDto.verbs.size} verbos")
                
            } catch (e: IOException) {
                Log.e(TAG, "Erro ao ler arquivo $fileName", e)
                throw e
            } catch (e: JsonSyntaxException) {
                Log.e(TAG, "Erro ao fazer parse do JSON em $fileName", e)
                throw e
            }
        }
        
        Log.i(TAG, "Total de verbos carregados: ${allVerbs.size}")
        
        // Retorna o último DTO com todos os verbos combinados
        lastConjugationsDto.copy(verbs = allVerbs)
    }
    
    /**
     * Lê o conteúdo de um arquivo JSON dos assets
     * 
     * @param context Contexto do Android
     * @param fileName Nome do arquivo a ser lido
     * @return Conteúdo do arquivo como String
     * @throws IOException Se houver erro ao ler o arquivo
     */
    private fun readJsonFromAsset(context: Context, fileName: String): String {
        return try {
            context.assets.open(fileName).bufferedReader().use { reader ->
                reader.readText()
            }
        } catch (e: IOException) {
            Log.e(TAG, "Erro ao abrir arquivo $fileName dos assets", e)
            throw IOException("Não foi possível ler o arquivo $fileName dos assets", e)
        }
    }
    
    /**
     * Faz o parse do JSON para ConjugationsDto
     * 
     * @param jsonContent Conteúdo JSON como String
     * @param fileName Nome do arquivo (usado para log)
     * @return ConjugationsDto parseado
     * @throws JsonSyntaxException Se houver erro no parse
     */
    private fun parseJson(jsonContent: String, fileName: String): ConjugationsDto {
        return try {
            gson.fromJson(jsonContent, ConjugationsDto::class.java)
        } catch (e: JsonSyntaxException) {
            Log.e(TAG, "JSON inválido no arquivo $fileName", e)
            throw JsonSyntaxException("Erro ao fazer parse do JSON em $fileName", e)
        }
    }
    
    companion object {
        private const val TAG = "JsonDataSource"
    }
}

