package com.helvio.laconjugacion.datasource.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.helvio.laconjugacion.datasource.model.conjugation.HeSheYouFormalConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.IConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.TheyYouPluralConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.VerbEntity
import com.helvio.laconjugacion.datasource.model.conjugation.WeConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.YouInformalConjugationEntity
import com.helvio.laconjugacion.datasource.model.conjugation.YouPluralInformalConjugationEntity

@Database(
    entities = [
        VerbEntity::class,
        IConjugationEntity::class,
        YouInformalConjugationEntity::class,
        HeSheYouFormalConjugationEntity::class,
        WeConjugationEntity::class,
        YouPluralInformalConjugationEntity::class,
        TheyYouPluralConjugationEntity::class
    ],
    version = 1
)
abstract class LaConjugationDatabase : RoomDatabase() {
    abstract fun getDao(): LaConjugationDao
}