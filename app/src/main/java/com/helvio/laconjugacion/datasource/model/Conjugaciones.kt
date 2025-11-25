package com.helvio.laconjugacion.datasource.model

import com.google.gson.annotations.SerializedName

data class Conjugaciones(
    @SerializedName("él/ella/usted")
    val ellosEllasUstedes: Ellosellasustedes,
    @SerializedName("nosotros/nosotras")
    val nosotrosNosotras: Nosotrosnosotras,
    @SerializedName("tú")
    val tu: Tu,
    @SerializedName("vosotros/vosotras")
    val vosotrosVosotras: Vosotrosvosotras,
    @SerializedName("yo")
    val yo: Yo,
    @SerializedName("ellos/ellas/ustedes")
    val elEllaUsted: Elellausted
)