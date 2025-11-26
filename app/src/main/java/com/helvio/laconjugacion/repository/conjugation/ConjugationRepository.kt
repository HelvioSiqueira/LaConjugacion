package com.helvio.laconjugacion.repository.conjugation

import android.content.Context
import com.helvio.laconjugacion.datasource.data.json.IJsonDataSource
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.toModel
import com.helvio.laconjugacion.datasource.model.getJsonFiles
import com.helvio.laconjugacion.repository.model.GetConjugationResult

class ConjugationRepository(
    private val jsonDataSource: IJsonDataSource
) : IConjugationRepository {

    override suspend fun getConjugationByVerbTense(
        context: Context,
        verbTense: VerbTenseEnum
    ): GetConjugationResult {
        return try {
            val conjugationsDto = jsonDataSource.loadConjugations(
                context = context,
                files = verbTense.getJsonFiles()
            )
            
            GetConjugationResult.Success(conjugationsDto.toModel())
            
        } catch (e: Exception) {
            GetConjugationResult.Failure(
                errorMessage = e.message ?: "Erro desconhecido ao carregar conjugações"
            )
        }
    }
}