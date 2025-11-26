package com.helvio.laconjugacion.datasource.model.conjugation

import com.google.gson.annotations.SerializedName

data class Conjugations(
    @SerializedName("él/ella/usted")
    val heSheYouFormal: HeSheYouFormalConjugation,
    @SerializedName("nosotros/nosotras")
    val we: WeConjugation,
    @SerializedName("tú")
    val youInformal: YouInformalConjugation,
    @SerializedName("vosotros/vosotras")
    val youPluralInformal: YouPluralInformalConjugation,
    @SerializedName("yo")
    val i: IConjugation,
    @SerializedName("ellos/ellas/ustedes")
    val theyYouPlural: TheyYouPluralConjugation
)

