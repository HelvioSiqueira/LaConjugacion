package com.helvio.laconjugacion.core.di

import androidx.room.Room
import com.helvio.laconjugacion.data.local.database.LaConjugationDatabase
import com.helvio.laconjugacion.data.repository.ConjugationRepository
import com.helvio.laconjugacion.data.source.json.IJsonDataSource
import com.helvio.laconjugacion.data.source.json.JsonDataSource
import com.helvio.laconjugacion.data.source.local.ILocalDataSource
import com.helvio.laconjugacion.data.source.local.LocalDataSource
import com.helvio.laconjugacion.domain.repository.IConjugationRepository
import com.helvio.laconjugacion.domain.usecase.GetConjugationsUseCase
import com.helvio.laconjugacion.presentation.conjugations.ConjugationsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val module = module {
        factory<IJsonDataSource> { JsonDataSource() }

        single {
            Room.databaseBuilder(
                    androidContext(),
                    LaConjugationDatabase::class.java,
                    "la_conjugation.db",
                )
                .build()
        }

        single { get<LaConjugationDatabase>().getDao() }

        factory<ILocalDataSource> { LocalDataSource(get()) }

        factory<IConjugationRepository> {
            ConjugationRepository(jsonDataSource = get(), localDataSource = get())
        }

        factory { GetConjugationsUseCase(repository = get()) }

        viewModel { ConjugationsViewModel(getConjugationsUseCase = get()) }
    }
}
