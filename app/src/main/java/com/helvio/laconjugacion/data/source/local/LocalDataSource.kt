package com.helvio.laconjugacion.data.source.local

import android.util.Log
import com.helvio.laconjugacion.data.local.dao.LaConjugationDao
import com.helvio.laconjugacion.data.local.entity.VerbWithConjugations
import com.helvio.laconjugacion.data.local.entity.toConjugationEntities
import com.helvio.laconjugacion.data.local.entity.toEntity
import com.helvio.laconjugacion.domain.model.VerbalTenseEnum
import com.helvio.laconjugacion.domain.model.dto.VerbDto
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: LaConjugationDao) : ILocalDataSource {
    override suspend fun saveConjugations(verbDtoList: List<VerbDto>, verbTense: VerbalTenseEnum) {

        verbDtoList.forEach { verbDto ->
            Log.d("HSV", verbDto.toString())
            val verbId = dao.insertVerbs(verbDto.toEntity(verbTense.value))

            val conjugationEntities = verbDto.toConjugationEntities(verbId)

            dao.insertAllIConjugations(conjugationEntities.iConjugation)
            dao.insertYouConjugations(conjugationEntities.youInformalConjugation)
            dao.insertHeSheYouFormalConjugations(conjugationEntities.heSheYouFormalConjugation)
            dao.insertWeConjugations(conjugationEntities.weConjugation)
            dao.insertYouPluralInformalConjugations(
                conjugationEntities.youPluralInformalConjugation
            )
            dao.insertTheyYouPluralConjugations(conjugationEntities.theyYouPluralConjugation)
        }
    }

    override fun getConjugationsByVerbTense(
        verbTense: VerbalTenseEnum
    ): Flow<List<VerbWithConjugations>> {
        return dao.getConjugationsByVerbTense(verbTense.value)
    }

    override suspend fun getConjugationByVerbAndTense(
        verbTense: VerbalTenseEnum,
        infinitive: String,
    ): VerbWithConjugations? {
        return dao.getConjugationByVerbAndTense(verbTense.value, infinitive)
    }
}
