package com.helvio.laconjugacion.datasource.data.local

import androidx.room.Dao
import androidx.room.Insert
import com.helvio.laconjugacion.datasource.model.conjugation.*

@Dao
interface LaConjugationDao {

    @Insert
    suspend fun insertAllIConjugations(vararg iConjugations: IConjugationEntity)

    @Insert
    suspend fun insertYouConjugations(vararg youInformalConjugation: YouInformalConjugationEntity)

    @Insert
    suspend fun insertHeSheYouFormalConjugations(vararg heSheYouFormalConjugation: HeSheYouFormalConjugationEntity)

    @Insert
    suspend fun insertWeConjugations(vararg weConjugation: WeConjugationEntity)

    @Insert
    suspend fun insertYouPluralInformalConjugations(vararg youPluralInformalConjugation: YouPluralInformalConjugationEntity)

    @Insert
    suspend fun insertTheyYouPluralConjugations(vararg theyYouPluralConjugation: TheyYouPluralConjugationEntity)

    @Insert
    suspend fun insertVerbs(vararg verbs: VerbEntity)

}