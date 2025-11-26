package com.helvio.laconjugacion.datasource.datasource

import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto

interface ILocalDataSource {
    suspend fun saveConjugations(verbDtoList: List<VerbDto>, verbTense: VerbTenseEnum)
}
