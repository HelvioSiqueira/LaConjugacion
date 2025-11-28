package com.helvio.laconjugacion.presentation.navigation

import com.helvio.laconjugacion.domain.model.VerbalTenseEnum
import kotlinx.serialization.Serializable

object NavPages {

    @Serializable object SelectVerbalTense

    @Serializable data class ConjugationsPage(val verbalTense: VerbalTenseEnum)
}
