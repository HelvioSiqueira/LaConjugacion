package com.helvio.laconjugacion.domain.model.dto

import com.google.gson.annotations.SerializedName
import com.helvio.laconjugacion.domain.model.ConjugationsModel
import com.helvio.laconjugacion.domain.model.VerbalTenseEnum

data class IConjugationDto(
    @SerializedName("ejemplo") val example: String?,
    @SerializedName("forma") val form: String,
)

data class YouInformalConjugationDto(
    @SerializedName("ejemplo") val example: String?,
    @SerializedName("forma") val form: String,
)

data class HeSheYouFormalConjugationDto(
    @SerializedName("ejemplo") val example: String?,
    @SerializedName("forma") val form: String,
)

data class WeConjugationDto(
    @SerializedName("ejemplo") val example: String?,
    @SerializedName("forma") val form: String,
)

data class YouPluralInformalConjugationDto(
    @SerializedName("ejemplo") val example: String?,
    @SerializedName("forma") val form: String,
)

data class TheyYouPluralConjugationDto(
    @SerializedName("ejemplo") val example: String?,
    @SerializedName("forma") val form: String,
)

data class PersonConjugationsDto(
    @SerializedName("él/ella/usted") val heSheYouFormal: HeSheYouFormalConjugationDto,
    @SerializedName("nosotros/nosotras") val we: WeConjugationDto,
    @SerializedName("tú") val youInformal: YouInformalConjugationDto,
    @SerializedName("vosotros/vosotras") val youPluralInformal: YouPluralInformalConjugationDto,
    @SerializedName("yo") val i: IConjugationDto,
    @SerializedName("ellos/ellas/ustedes") val theyYouPlural: TheyYouPluralConjugationDto,
)

data class VerbDto(
    @SerializedName("numero") val number: Int,
    @SerializedName("conjugaciones") val conjugations: PersonConjugationsDto,
    @SerializedName("infinitivo") val infinitive: String,
    @SerializedName("tipo") val type: String,
    @SerializedName("traducao") val translation: String,
)

data class ConjugationsDto(
    @SerializedName("descripcion") val description: String = "",
    @SerializedName("tiempo_verbal") val verbTense: String = "",
    @SerializedName("titulo") val title: String = "",
    @SerializedName("verbos") val verbs: List<VerbDto> = emptyList(),
)

fun ConjugationsDto.toModel() =
    ConjugationsModel(
        description = description,
        verbTense = VerbalTenseEnum.fromValue(verbTense),
        title = title,
        verbs = verbs,
    )
