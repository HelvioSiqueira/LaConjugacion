package com.helvio.laconjugacion.datasource.model.conjugation

import com.google.gson.annotations.SerializedName

data class HeSheYouFormalConjugation(
    @SerializedName("ejemplo")
    val example: String?,
    @SerializedName("forma")
    val form: String
)

