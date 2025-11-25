package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class Verb(
    @SerializedName("numero")
    val number: Int,
    @SerializedName("conjugaciones")
    val conjugations: Conjugations,
    @SerializedName("infinitivo")
    val infinitive: String,
    @SerializedName("tipo")
    val type: String,
    @SerializedName("traducao")
    val translation: String
)

