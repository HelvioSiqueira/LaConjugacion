package com.helvio.laconjugacion.repository.conjugation

import android.content.Context
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.repository.model.GetConjugationResult

/**
 * Interface do Repository de Conjugações.
 * Define o contrato para obter dados de conjugação de verbos.
 */
interface IConjugationRepository {

    /**
     * Obtém as conjugações para um tempo verbal específico.
     * 
     * @param context Contexto do Android
     * @param verbTense Tempo verbal desejado
     * @return GetConjugationResult.Success com o modelo ou GetConjugationResult.Failure em caso de erro
     */
    suspend fun getConjugationByVerbTense(
        context: Context,
        verbTense: VerbTenseEnum
    ): GetConjugationResult
}