package com.helvio.laconjugacion.di

import com.helvio.laconjugacion.datasource.data.json.IJsonDataSource
import com.helvio.laconjugacion.datasource.data.json.JsonDataSource
import com.helvio.laconjugacion.datasource.data.local.LaConjugationDatabase
import com.helvio.laconjugacion.repository.conjugation.ConjugationRepository
import com.helvio.laconjugacion.repository.conjugation.IConjugationRepository
import org.koin.dsl.module

object AppModule {
    val module = module {
        factory<IJsonDataSource> { JsonDataSource() }
        
        single { get<LaConjugationDatabase>().getDao() }
        
        factory<IConjugationRepository> {
            ConjugationRepository(
                jsonDataSource = get()
            ) 
        }
    }
}