package com.helvio.laconjugacion.data.source.local

import com.helvio.laconjugacion.data.local.entity.VerbWithConjugations
import com.helvio.laconjugacion.domain.model.VerbTenseEnum
import com.helvio.laconjugacion.domain.model.dto.VerbDto
import kotlinx.coroutines.flow.Flow

interface ILocalDataSource {
    suspend fun saveConjugations(verbDtoList: List<VerbDto>, verbTense: VerbTenseEnum)

    fun getConjugationsByVerbTense(verbTense: VerbTenseEnum): Flow<List<VerbWithConjugations>>

    suspend fun getConjugationByVerbAndTense(
        verbTense: VerbTenseEnum,
        infinitive: String,
    ): VerbWithConjugations?
}
