package com.helvio.laconjugacion.domain.usecase

import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.repository.conjugation.IConjugationRepository
import com.helvio.laconjugacion.repository.model.GetConjugationResult
import kotlinx.coroutines.flow.Flow

class GetConjugationsUseCase(private val repository: IConjugationRepository) {
    operator fun invoke(verbTense: VerbTenseEnum): Flow<GetConjugationResult> {
        return repository.getConjugationsByVerbTense(verbTense)
    }
}

