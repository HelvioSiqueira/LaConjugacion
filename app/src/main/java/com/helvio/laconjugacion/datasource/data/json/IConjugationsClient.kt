package com.helvio.laconjugacion.datasource.data.json

import android.content.Context
import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsDto

interface IConjugationsClient {

    fun getConjugations(context: Context, files: List<String>): ConjugationsDto
}