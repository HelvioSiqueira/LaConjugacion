package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class Yo(
    @SerializedName("ejemplo")
    val ejemplo: String,
    @SerializedName("forma")
    val forma: String
)