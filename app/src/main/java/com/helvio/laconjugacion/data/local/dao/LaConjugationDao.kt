package com.helvio.laconjugacion.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.helvio.laconjugacion.data.local.entity.HeSheYouFormalConjugationEntity
import com.helvio.laconjugacion.data.local.entity.IConjugationEntity
import com.helvio.laconjugacion.data.local.entity.TheyYouPluralConjugationEntity
import com.helvio.laconjugacion.data.local.entity.VerbEntity
import com.helvio.laconjugacion.data.local.entity.VerbWithConjugations
import com.helvio.laconjugacion.data.local.entity.WeConjugationEntity
import com.helvio.laconjugacion.data.local.entity.YouInformalConjugationEntity
import com.helvio.laconjugacion.data.local.entity.YouPluralInformalConjugationEntity
import kotlinx.coroutines.flow.Flow

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

    @Transaction
    @Query("SELECT * FROM verbs WHERE verb_tense = :verbTense ORDER BY number")
    fun getConjugationsByVerbTense(verbTense: String): Flow<List<VerbWithConjugations>>

    @Transaction
    @Query("SELECT * FROM verbs WHERE verb_tense = :verbTense AND infinitive = :infinitive LIMIT 1")
    suspend fun getConjugationByVerbAndTense(
        verbTense: String,
        infinitive: String,
    ): VerbWithConjugations?
}
