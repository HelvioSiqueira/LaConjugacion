package com.helvio.laconjugacion.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import com.helvio.laconjugacion.datasource.model.conjugation.HeSheYouFormalConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.IConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.TheyYouPluralConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.VerbEntity
import com.helvio.laconjugacion.datasource.model.conjugation.WeConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.YouInformalConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.YouPluralInformalConjugationEntity

@Dao
interface LaConjugationDao {

    @Insert suspend fun insertAllIConjugations(vararg iConjugations: IConjugationEntity)

    @Insert
    suspend fun insertYouConjugations(vararg youInformalConjugation: YouInformalConjugationEntity)

    @Insert
    suspend fun insertHeSheYouFormalConjugations(
        vararg heSheYouFormalConjugation: HeSheYouFormalConjugationEntity
    )

    @Insert suspend fun insertWeConjugations(vararg weConjugation: WeConjugationEntity)

    @Insert
    suspend fun insertYouPluralInformalConjugations(
        vararg youPluralInformalConjugation: YouPluralInformalConjugationEntity
    )

    @Insert
    suspend fun insertTheyYouPluralConjugations(
        vararg theyYouPluralConjugation: TheyYouPluralConjugationEntity
    )

    @Insert suspend fun insertVerbs(verbs: VerbEntity): Long
}
