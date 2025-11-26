package com.helvio.laconjugacion.datasource.model.conjugation

import com.helvio.laconjugacion.datasource.model.VerbTenseEnum

data class ConjugationsModel(
    val description: String = "",
    val verbTense: VerbTenseEnum = VerbTenseEnum.PRESENT_INDICATIVE,
    val title: String = "",
    val verbs: List<Verb> = emptyList()
)
