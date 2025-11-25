package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class Verbo(
    @SerializedName("numero")
    val numero: Int,
    @SerializedName("conjugaciones")
    val conjugaciones: Conjugaciones,
    @SerializedName("infinitivo")
    val infinitivo: String,
    @SerializedName("tipo")
    val tipo: String,
    @SerializedName("traducao")
    val traducao: String
)