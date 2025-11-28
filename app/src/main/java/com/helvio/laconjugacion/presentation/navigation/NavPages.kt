package com.helvio.laconjugacion.presentation.navigation

import com.helvio.laconjugacion.domain.model.VerbTenseEnum
import kotlinx.serialization.Serializable

object NavPages {

    @Serializable object SelectVerbalTense

    @Serializable data class ConjugationsPage(val verbalTense: VerbTenseEnum)
}
