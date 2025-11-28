package com.helvio.laconjugacion.di

import androidx.room.Room
import com.helvio.laconjugacion.datasource.database.LaConjugationDatabase
import com.helvio.laconjugacion.datasource.datasource.IJsonDataSource
import com.helvio.laconjugacion.datasource.datasource.ILocalDataSource
import com.helvio.laconjugacion.datasource.datasource.JsonDataSource
import com.helvio.laconjugacion.datasource.datasource.LocalDataSource
import com.helvio.laconjugacion.domain.usecase.GetConjugationsUseCase
import com.helvio.laconjugacion.repository.conjugation.ConjugationRepository
import com.helvio.laconjugacion.repository.conjugation.IConjugationRepository
import com.helvio.laconjugacion.ui.conjugations.ConjugationsViewModel
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
