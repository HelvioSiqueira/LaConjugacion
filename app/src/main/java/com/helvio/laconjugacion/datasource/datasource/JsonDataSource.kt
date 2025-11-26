package com.helvio.laconjugacion.datasource.datasource

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsDto
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class JsonDataSource : IJsonDataSource {
    
    private val gson = Gson()

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

