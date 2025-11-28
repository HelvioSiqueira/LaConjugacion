package com.helvio.laconjugacion.domain.model

import com.helvio.laconjugacion.domain.model.dto.VerbDto

data class ConjugationsModel(
    val description: String = "",
    val verbTense: VerbTenseEnum = VerbTenseEnum.PRESENT_INDICATIVE,
    val title: String = "",
    val verbs: List<VerbDto> = emptyList(),
)
