package com.helvio.laconjugacion.data.source.json

import android.content.Context
import com.helvio.laconjugacion.domain.model.dto.ConjugationsDto

interface IJsonDataSource {
    suspend fun loadConjugations(context: Context, files: List<String>): ConjugationsDto
}
