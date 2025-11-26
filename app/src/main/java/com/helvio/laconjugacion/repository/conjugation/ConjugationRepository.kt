package com.helvio.laconjugacion.repository.conjugation

import android.content.Context
import com.helvio.laconjugacion.datasource.data.json.IConjugationsClient
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.toModel
import com.helvio.laconjugacion.datasource.model.getJsonFiles
import com.helvio.laconjugacion.repository.model.GetConjugationResult

class ConjugationRepository(val client: IConjugationsClient) : IConjugationRepository {
    override fun getConjugationByVerbTense(
        context: Context,
        verbTense: VerbTenseEnum
    ): GetConjugationResult {

        return try {
            val conjugations = client.getConjugations(context, verbTense.getJsonFiles())
            GetConjugationResult.Success(conjugations.toModel())
        } catch (e: Exception) {
            GetConjugationResult.Failure(e.message.toString())
        }
    }
}