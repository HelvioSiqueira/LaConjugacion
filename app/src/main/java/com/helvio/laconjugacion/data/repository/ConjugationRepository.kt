package com.helvio.laconjugacion.data.repository

import android.content.Context
import com.helvio.laconjugacion.data.local.entity.toModel
import com.helvio.laconjugacion.data.source.json.IJsonDataSource
import com.helvio.laconjugacion.data.source.local.ILocalDataSource
import com.helvio.laconjugacion.domain.model.GetConjugationResult
import com.helvio.laconjugacion.domain.model.VerbTenseEnum
import com.helvio.laconjugacion.domain.model.dto.VerbDto
import com.helvio.laconjugacion.domain.model.getJsonFiles
import com.helvio.laconjugacion.domain.repository.IConjugationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class ConjugationRepository(
    private val jsonDataSource: IJsonDataSource,
    private val localDataSource: ILocalDataSource,
) : IConjugationRepository {

    override suspend fun getAllConjugations(context: Context) {
        VerbTenseEnum.entries.forEach { verbTense ->
            val conjugationsDto =
                jsonDataSource.loadConjugations(context = context, files = verbTense.getJsonFiles())

            saveConjugations(conjugationsDto.verbs, verbTense)
        }
    }

    override fun getConjugationsByVerbTense(verbTense: VerbTenseEnum): Flow<GetConjugationResult> {
        return localDataSource
            .getConjugationsByVerbTense(verbTense)
            .map { verbWithConjugations ->
                val conjugationsModel = verbWithConjugations.toModel(verbTense)
                GetConjugationResult.Success(conjugationsModel) as GetConjugationResult
            }
            .onStart { emit(GetConjugationResult.Loading) }
            .catch { exception ->
                emit(GetConjugationResult.Failure(exception.message ?: "Erro desconhecido"))
            }
    }

    private suspend fun saveConjugations(verbDto: List<VerbDto>, verbTense: VerbTenseEnum) {
        localDataSource.saveConjugations(verbDto, verbTense)
    }
}
