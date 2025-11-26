package com.helvio.laconjugacion.repository.conjugation

import android.content.Context

interface IConjugationRepository {

    suspend fun getAllConjugations(context: Context)
}
