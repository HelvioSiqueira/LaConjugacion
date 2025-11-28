package com.helvio.laconjugacion.ui.routes

import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import kotlinx.serialization.Serializable

object NavPages {

    @Serializable
    object SelectVerbalTense

    @Serializable
    data class ConjugationsPage(val verbalTense: VerbTenseEnum)
}
