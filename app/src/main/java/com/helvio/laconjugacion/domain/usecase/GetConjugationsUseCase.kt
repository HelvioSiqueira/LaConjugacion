package com.helvio.laconjugacion.domain.usecase

import com.helvio.laconjugacion.domain.model.GetConjugationResult
import com.helvio.laconjugacion.domain.model.VerbalTenseEnum
import com.helvio.laconjugacion.domain.repository.IConjugationRepository
import kotlinx.coroutines.flow.Flow

class GetConjugationsUseCase(private val repository: IConjugationRepository) {
    operator fun invoke(verbTense: VerbalTenseEnum): Flow<GetConjugationResult> {
        return repository.getConjugationsByVerbTense(verbTense)
    }
}

