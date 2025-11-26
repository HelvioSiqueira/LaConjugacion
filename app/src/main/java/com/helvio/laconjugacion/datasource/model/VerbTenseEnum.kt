package com.helvio.laconjugacion.datasource.model

enum class VerbTenseEnum(val value: String) {

    PRESENT_INDICATIVE("presente_indicativo"),
    CONDITIONAL_SIMPLE("condicional_simple"),
    FUTURE_SIMPLE("futuro_simple"),
    IMPERFECT_TENSE("preterito_imperfecto"),
    PRETERITE_PERFECT_TENSE("preterito_perfecto_compuesto"),
    PRETERITE_INDEFINITE("preterito_indefinido"),
    PRESENT_SUBJUNCTIVE("presente_subjutivo");

    companion object {
        fun fromValue(value: String?): VerbTenseEnum =
            VerbTenseEnum.entries.find { it.value.equals(value, ignoreCase = true) }
                ?: PRESENT_INDICATIVE
    }
}

fun VerbTenseEnum.getJsonFiles(): List<String> {

    return when (this) {
        VerbTenseEnum.PRESENT_INDICATIVE ->
            listOf(
                "present_indicative_1.json",
                "present_indicative_2.json",
                "present_indicative_3.json",
                "present_indicative_4.json",
            )

        VerbTenseEnum.CONDITIONAL_SIMPLE ->
            listOf(
                "conditional_simple_1.json",
                "conditional_simple_2.json",
                "conditional_simple_3.json",
                "conditional_simple_4.json",
            )

        VerbTenseEnum.FUTURE_SIMPLE ->
            listOf(
                "future_simple_1.json",
                "future_simple_2.json",
                "future_simple_3.json",
                "future_simple_4.json",
            )

        VerbTenseEnum.IMPERFECT_TENSE ->
            listOf(
                "imperfect_tense_1.json",
                "imperfect_tense_2.json",
                "imperfect_tense_3.json",
                "imperfect_tense_4.json",
            )

        VerbTenseEnum.PRETERITE_PERFECT_TENSE -> listOf("preterite_perfect_tense_1.json")
        VerbTenseEnum.PRETERITE_INDEFINITE ->
            listOf(
                "preterite_indefinite_1.json",
                "preterite_indefinite_2.json",
                "preterite_indefinite_3.json",
                "preterite_indefinite_4.json",
            )

        VerbTenseEnum.PRESENT_SUBJUNCTIVE ->
            listOf(
                "present_subjunctive_1.json",
                "present_subjunctive_2.json",
                "present_subjunctive_3.json",
                "present_subjunctive_4.json",
            )
    }
}
