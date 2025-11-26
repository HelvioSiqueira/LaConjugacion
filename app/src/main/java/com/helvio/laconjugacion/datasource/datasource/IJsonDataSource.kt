package com.helvio.laconjugacion.datasource.datasource

import android.content.Context
import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsDto

interface IJsonDataSource {
    suspend fun loadConjugations(context: Context, files: List<String>): ConjugationsDto
}

