package com.helvio.laconjugacion.data.source.local

import com.helvio.laconjugacion.data.local.entity.VerbWithConjugations
import com.helvio.laconjugacion.domain.model.VerbalTenseEnum
import com.helvio.laconjugacion.domain.model.dto.VerbDto
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    suspend fun saveConjugations(verbDtoList: List<VerbDto>, verbTense: VerbalTenseEnum)

    fun getConjugationsByVerbTense(verbTense: VerbalTenseEnum): Flow<List<VerbWithConjugations>>

    suspend fun getConjugationByVerbAndTense(
        verbTense: VerbalTenseEnum,
        infinitive: String,
    ): VerbWithConjugations?
}
