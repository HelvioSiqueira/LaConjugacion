package com.helvio.laconjugacion.repository.model

import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsModel

sealed class GetConjugationResult {
    data class Success(val data: ConjugationsModel) : GetConjugationResult()

    data class Failure(val errorMessage: String) : GetConjugationResult()

    object Loading : GetConjugationResult()
}
