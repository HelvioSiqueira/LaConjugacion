package com.helvio.laconjugacion.datasource.model.conjugation

import com.google.gson.annotations.SerializedName
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum

data class ConjugationsDto(
    @SerializedName("descripcion")
    val description: String = "",
    @SerializedName("tiempo_verbal")
    val verbTense: String = "",
    @SerializedName("titulo")
    val title: String = "",
    @SerializedName("verbos")
    val verbs: List<Verb> = emptyList()
)

fun ConjugationsDto.toModel() = ConjugationsModel(
    description = description,
    verbTense = VerbTenseEnum.fromValue(verbTense),
    title = title,
    verbs = verbs
)