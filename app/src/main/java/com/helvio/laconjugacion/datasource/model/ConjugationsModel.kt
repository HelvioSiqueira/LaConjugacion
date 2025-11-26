package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class ConjugationsModel(
    @SerializedName("descripcion")
    val description: String = "",
    @SerializedName("tiempo_verbal")
    val verbTense: String = "",
    @SerializedName("titulo")
    val title: String = "",
    @SerializedName("verbos")
    val verbs: List<Verb> = emptyList()
)