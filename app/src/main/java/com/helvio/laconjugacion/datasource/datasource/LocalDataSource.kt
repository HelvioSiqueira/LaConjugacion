package com.helvio.laconjugacion.datasource.datasource

import android.util.Log
import com.helvio.laconjugacion.datasource.dao.LaConjugationDao
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto
import com.helvio.laconjugacion.datasource.model.conjugation.toConjugationEntities
import com.helvio.laconjugacion.datasource.model.conjugation.toEntity

class LocalDataSource(
    private val dao: LaConjugationDao
) : ILocalDataSource {
    override suspend fun saveConjugations(
        verbDtoList: List<VerbDto>,
        verbTense: VerbTenseEnum
    ) {

        verbDtoList.forEach { verbDto ->
            Log.d("HSV", verbDto.toString())
           val verbId = dao.insertVerbs(verbDto.toEntity(verbTense.value))

            val conjugationEntities = verbDto.toConjugationEntities(verbId)

            dao.insertAllIConjugations(conjugationEntities.iConjugation)
            dao.insertYouConjugations(conjugationEntities.youInformalConjugation)
            dao.insertHeSheYouFormalConjugations(conjugationEntities.heSheYouFormalConjugation)
            dao.insertWeConjugations(conjugationEntities.weConjugation)
            dao.insertYouPluralInformalConjugations(conjugationEntities.youPluralInformalConjugation)
            dao.insertTheyYouPluralConjugations(conjugationEntities.theyYouPluralConjugation)
        }
    }
}