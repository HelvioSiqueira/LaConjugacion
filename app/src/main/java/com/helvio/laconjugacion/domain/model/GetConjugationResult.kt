package com.helvio.laconjugacion.domain.model

sealed class GetConjugationResult {
    data class Success(val data: ConjugationsModel) : GetConjugationResult()

    data class Failure(val errorMessage: String) : GetConjugationResult()

    object Loading : GetConjugationResult()
}
