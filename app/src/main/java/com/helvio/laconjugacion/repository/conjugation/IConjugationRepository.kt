package com.helvio.laconjugacion.repository.conjugation

import android.content.Context
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto
import com.helvio.laconjugacion.repository.model.GetConjugationResult

interface IConjugationRepository {

    suspend fun getAllConjugations(
        context: Context,
    )


}