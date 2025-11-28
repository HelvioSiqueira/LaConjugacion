package com.helvio.laconjugacion.repository.conjugation

import android.content.Context
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.repository.model.GetConjugationResult
import kotlinx.coroutines.flow.Flow

interface IConjugationRepository {

    suspend fun getAllConjugations(context: Context)

    fun getConjugationsByVerbTense(verbTense: VerbTenseEnum): Flow<GetConjugationResult>
}
