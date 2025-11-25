package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class ConjugationsModel(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("tiempo_verbal")
    val tiempoVerbal: String,
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("verbos")
    val verbos: List<Verbo>
)