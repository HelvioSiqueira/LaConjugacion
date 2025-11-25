package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class WeConjugation(
    @SerializedName("ejemplo")
    val example: String?,
    @SerializedName("forma")
    val form: String
)

