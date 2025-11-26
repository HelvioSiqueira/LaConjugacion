package com.helvio.laconjugacion.datasource.model.conjugation

import com.google.gson.annotations.SerializedName

data class IConjugation(
    @SerializedName("ejemplo")
    val example: String?,
    @SerializedName("forma")
    val form: String
)

