package com.helvio.laconjugacion.domain.usecase

import android.content.Context
import com.helvio.laconjugacion.domain.repository.IConjugationRepository

class GetAllConjugationsUseCase(private val repository: IConjugationRepository) {
    suspend operator fun invoke(context: Context) {
        repository.getAllConjugations(context)
    }
}

