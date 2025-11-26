package com.helvio.laconjugacion.datasource.data.json

import android.content.Context
import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsDto

/**
 * Interface para o Data Source que lê dados de arquivos JSON dos assets
 */
interface IJsonDataSource {
    
    /**
     * Carrega conjugações de múltiplos arquivos JSON
     * 
     * @param context Contexto do Android para acessar os assets
     * @param files Lista de nomes de arquivos JSON a serem carregados
     * @return ConjugationsDto com todos os verbos dos arquivos carregados
     */
    suspend fun loadConjugations(context: Context, files: List<String>): ConjugationsDto
}

