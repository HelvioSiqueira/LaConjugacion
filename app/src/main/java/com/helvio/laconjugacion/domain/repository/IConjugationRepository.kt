package com.helvio.laconjugacion.domain.repository

import android.content.Context
import com.helvio.laconjugacion.domain.model.GetConjugationResult
import com.helvio.laconjugacion.domain.model.VerbTenseEnum
import kotlinx.coroutines.flow.Flow

interface IConjugationRepository {

    suspend fun getAllConjugations(context: Context)

    fun getConjugationsByVerbTense(verbTense: VerbTenseEnum): Flow<GetConjugationResult>
}
