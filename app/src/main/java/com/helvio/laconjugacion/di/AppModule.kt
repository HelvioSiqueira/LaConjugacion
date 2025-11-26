package com.helvio.laconjugacion.di

import com.helvio.laconjugacion.datasource.data.ConjugationsClient
import com.helvio.laconjugacion.datasource.data.IConjugationsClient
import com.helvio.laconjugacion.repository.conjugation.ConjugationRepository
import com.helvio.laconjugacion.repository.conjugation.IConjugationRepository
import org.koin.dsl.module

object AppModule {
    val module = module {
        factory<IConjugationsClient> {
            ConjugationsClient()
        }

        factory<IConjugationRepository> {
            ConjugationRepository(get())
        }
    }
}