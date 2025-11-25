package com.helvio.laconjugacion.datasource.data

import android.content.Context
import com.helvio.laconjugacion.datasource.model.ConjugationsModel

interface IConjugationsClient {

    fun getConjugations(context: Context, files: List<String>): ConjugationsModel
}