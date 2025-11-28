package com.helvio.laconjugacion.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.helvio.laconjugacion.data.local.dao.LaConjugationDao
import com.helvio.laconjugacion.data.local.entity.HeSheYouFormalConjugationEntity
import com.helvio.laconjugacion.data.local.entity.IConjugationEntity
import com.helvio.laconjugacion.data.local.entity.TheyYouPluralConjugationEntity
import com.helvio.laconjugacion.data.local.entity.VerbEntity
import com.helvio.laconjugacion.data.local.entity.WeConjugationEntity
import com.helvio.laconjugacion.data.local.entity.YouInformalConjugationEntity
import com.helvio.laconjugacion.data.local.entity.YouPluralInformalConjugationEntity

@Database(
    entities =
        [
            VerbEntity::class,
            IConjugationEntity::class,
            YouInformalConjugationEntity::class,
            HeSheYouFormalConjugationEntity::class,
            WeConjugationEntity::class,
            YouPluralInformalConjugationEntity::class,
            TheyYouPluralConjugationEntity::class,
        ],
    version = 1,
)
abstract class LaConjugationDatabase : RoomDatabase() {
    abstract fun getDao(): LaConjugationDao
}
