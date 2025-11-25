package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class Tu(
    @SerializedName("ejemplo")
    val ejemplo: String,
    @SerializedName("forma")
    val forma: String
)