package com.helvio.laconjugacion.domain.model

import android.content.Context
import com.helvio.laconjugacion.R

enum class VerbalTenseEnum(val value: String) {

    PRESENT_INDICATIVE("presente_indicativo"),
    CONDITIONAL_SIMPLE("condicional_simple"),
    FUTURE_SIMPLE("futuro_simple"),
    IMPERFECT_TENSE("preterito_imperfecto"),
    PRETERITE_PERFECT_TENSE("preterito_perfecto_compuesto"),
    PRETERITE_INDEFINITE("preterito_indefinido"),
    PRESENT_SUBJUNCTIVE("presente_subjutivo");

    companion object {
        fun fromValue(value: String?): VerbalTenseEnum =
            VerbalTenseEnum.entries.find { it.value.equals(value, ignoreCase = true) }
                ?: PRESENT_INDICATIVE
    }
}

fun VerbalTenseEnum.getJsonFiles(): List<String> {

    return when (this) {
        VerbalTenseEnum.PRESENT_INDICATIVE ->
            listOf(
                "present_indicative_1.json",
                "present_indicative_2.json",
                "present_indicative_3.json",
                "present_indicative_4.json",
            )

        VerbalTenseEnum.CONDITIONAL_SIMPLE ->
            listOf(
                "conditional_simple_1.json",
                "conditional_simple_2.json",
                "conditional_simple_3.json",
                "conditional_simple_4.json",
            )

        VerbalTenseEnum.FUTURE_SIMPLE ->
            listOf(
                "future_simple_1.json",
                "future_simple_2.json",
                "future_simple_3.json",
                "future_simple_4.json",
            )

        VerbalTenseEnum.IMPERFECT_TENSE ->
            listOf(
                "imperfect_tense_1.json",
                "imperfect_tense_2.json",
                "imperfect_tense_3.json",
                "imperfect_tense_4.json",
            )

        VerbalTenseEnum.PRETERITE_PERFECT_TENSE -> listOf("preterite_perfect_tense_1.json")
        VerbalTenseEnum.PRETERITE_INDEFINITE ->
            listOf(
                "preterite_indefinite_1.json",
                "preterite_indefinite_2.json",
                "preterite_indefinite_3.json",
                "preterite_indefinite_4.json",
            )

        VerbalTenseEnum.PRESENT_SUBJUNCTIVE ->
            listOf(
                "present_subjunctive_1.json",
                "present_subjunctive_2.json",
                "present_subjunctive_3.json",
                "present_subjunctive_4.json",
            )
    }
}

fun VerbalTenseEnum.getVerbalTenseString(): Int {

    return when (this) {
        VerbalTenseEnum.PRESENT_INDICATIVE -> R.string.title_present_indicative
        VerbalTenseEnum.CONDITIONAL_SIMPLE -> R.string.title_conditional_simple
        VerbalTenseEnum.FUTURE_SIMPLE -> R.string.title_future_simple
        VerbalTenseEnum.IMPERFECT_TENSE -> R.string.title_imperfect_tense
        VerbalTenseEnum.PRETERITE_PERFECT_TENSE -> R.string.title_preterite_perfect_tense
        VerbalTenseEnum.PRETERITE_INDEFINITE -> R.string.title_preterite_indefinite
        VerbalTenseEnum.PRESENT_SUBJUNCTIVE -> R.string.title_present_subjunctive
    }
}
