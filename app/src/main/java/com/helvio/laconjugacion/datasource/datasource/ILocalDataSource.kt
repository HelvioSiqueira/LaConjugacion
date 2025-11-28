package com.helvio.laconjugacion.datasource.datasource

import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto
import com.helvio.laconjugacion.datasource.model.conjugation.VerbWithConjugations
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    suspend fun saveConjugations(verbDtoList: List<VerbDto>, verbTense: VerbTenseEnum)

    fun getConjugationsByVerbTense(verbTense: VerbTenseEnum): Flow<List<VerbWithConjugations>>

    suspend fun getConjugationByVerbAndTense(
        verbTense: VerbTenseEnum,
        infinitive: String,
    ): VerbWithConjugations?
}
