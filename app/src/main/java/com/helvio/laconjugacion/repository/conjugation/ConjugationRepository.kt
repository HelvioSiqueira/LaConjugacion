package com.helvio.laconjugacion.repository.conjugation

import android.content.Context
import com.helvio.laconjugacion.datasource.datasource.IJsonDataSource
import com.helvio.laconjugacion.datasource.datasource.ILocalDataSource
import com.helvio.laconjugacion.datasource.datasource.LocalDataSource
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto
import com.helvio.laconjugacion.datasource.model.conjugation.toModel
import com.helvio.laconjugacion.datasource.model.getJsonFiles
import com.helvio.laconjugacion.repository.model.GetConjugationResult

class ConjugationRepository(
    private val jsonDataSource: IJsonDataSource,
    private val localDataSource: ILocalDataSource,
) : IConjugationRepository {

    override suspend fun getAllConjugations(
        context: Context,
    ) {
        VerbTenseEnum.entries.forEach { verbTense ->
            val conjugationsDto = jsonDataSource.loadConjugations(
                context = context,
                files = verbTense.getJsonFiles()
            )

            saveConjugations(conjugationsDto.verbs, verbTense)
        }
    }

    private suspend fun saveConjugations(
        verbDto: List<VerbDto>,
        verbTense: VerbTenseEnum
    ) {
        localDataSource.saveConjugations(verbDto, verbTense)
    }
}