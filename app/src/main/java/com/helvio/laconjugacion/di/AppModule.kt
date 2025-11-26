package com.helvio.laconjugacion.di

import com.helvio.laconjugacion.datasource.data.ConjugationsClient
import com.helvio.laconjugacion.datasource.data.IConjugationsClient
import org.koin.dsl.module

object AppModule {
    val module = module {
        factory<IConjugationsClient> {
            ConjugationsClient()
        }
    }
}