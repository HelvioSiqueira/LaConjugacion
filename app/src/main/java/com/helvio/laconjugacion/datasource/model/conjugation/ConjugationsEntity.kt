package com.helvio.laconjugacion.datasource.model.conjugation

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

// ==================== TABELA PRINCIPAL: VERBOS ====================

@Entity(
    tableName = "verbs",
    indices =
        [
            Index(value = ["verb_tense", "number"]),
            Index(value = ["infinitive"]),
            Index(value = ["verb_tense"]),
        ],
)
data class VerbEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "infinitive") val infinitive: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "translation") val translation: String,
    @ColumnInfo(name = "verb_tense") val verbTense: String,
)

// ==================== TABELAS DE CONJUGAÇÕES POR PRONOME ====================

@Entity(
    tableName = "i_conjugations",
    foreignKeys =
        [
            ForeignKey(
                entity = VerbEntity::class,
                parentColumns = ["id"],
                childColumns = ["verb_id"],
                onDelete = ForeignKey.CASCADE,
            )
        ],
    indices = [Index(value = ["verb_id"])],
)
data class IConjugationEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "verb_id") val verbId: Long,
    @ColumnInfo(name = "example") val example: String?,
    @ColumnInfo(name = "form") val form: String,
)

@Entity(
    tableName = "you_informal_conjugations",
    foreignKeys =
        [
            ForeignKey(
                entity = VerbEntity::class,
                parentColumns = ["id"],
                childColumns = ["verb_id"],
                onDelete = ForeignKey.CASCADE,
            )
        ],
    indices = [Index(value = ["verb_id"])],
)
data class YouInformalConjugationEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "verb_id") val verbId: Long,
    @ColumnInfo(name = "example") val example: String?,
    @ColumnInfo(name = "form") val form: String,
)

@Entity(
    tableName = "he_she_you_formal_conjugations",
    foreignKeys =
        [
            ForeignKey(
                entity = VerbEntity::class,
                parentColumns = ["id"],
                childColumns = ["verb_id"],
                onDelete = ForeignKey.CASCADE,
            )
        ],
    indices = [Index(value = ["verb_id"])],
)
data class HeSheYouFormalConjugationEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "verb_id") val verbId: Long,
    @ColumnInfo(name = "example") val example: String?,
    @ColumnInfo(name = "form") val form: String,
)

@Entity(
    tableName = "we_conjugations",
    foreignKeys =
        [
            ForeignKey(
                entity = VerbEntity::class,
                parentColumns = ["id"],
                childColumns = ["verb_id"],
                onDelete = ForeignKey.CASCADE,
            )
        ],
    indices = [Index(value = ["verb_id"])],
)
data class WeConjugationEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "verb_id") val verbId: Long,
    @ColumnInfo(name = "example") val example: String?,
    @ColumnInfo(name = "form") val form: String,
)

@Entity(
    tableName = "you_plural_informal_conjugations",
    foreignKeys =
        [
            ForeignKey(
                entity = VerbEntity::class,
                parentColumns = ["id"],
                childColumns = ["verb_id"],
                onDelete = ForeignKey.CASCADE,
            )
        ],
    indices = [Index(value = ["verb_id"])],
)
data class YouPluralInformalConjugationEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "verb_id") val verbId: Long,
    @ColumnInfo(name = "example") val example: String?,
    @ColumnInfo(name = "form") val form: String,
)

@Entity(
    tableName = "they_you_plural_conjugations",
    foreignKeys =
        [
            ForeignKey(
                entity = VerbEntity::class,
                parentColumns = ["id"],
                childColumns = ["verb_id"],
                onDelete = ForeignKey.CASCADE,
            )
        ],
    indices = [Index(value = ["verb_id"])],
)
data class TheyYouPluralConjugationEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "verb_id") val verbId: Long,
    @ColumnInfo(name = "example") val example: String?,
    @ColumnInfo(name = "form") val form: String,
)

data class VerbWithConjugations(
    @Embedded val verb: VerbEntity,
    @Relation(parentColumn = "id", entityColumn = "verb_id")
    val iConjugation: List<IConjugationEntity>,
    @Relation(parentColumn = "id", entityColumn = "verb_id")
    val youInformalConjugation: List<YouInformalConjugationEntity>,
    @Relation(parentColumn = "id", entityColumn = "verb_id")
    val heSheYouFormalConjugation: List<HeSheYouFormalConjugationEntity>,
    @Relation(parentColumn = "id", entityColumn = "verb_id")
    val weConjugation: List<WeConjugationEntity>,
    @Relation(parentColumn = "id", entityColumn = "verb_id")
    val youPluralInformalConjugation: List<YouPluralInformalConjugationEntity>,
    @Relation(parentColumn = "id", entityColumn = "verb_id")
    val theyYouPluralConjugation: List<TheyYouPluralConjugationEntity>,
)

fun VerbDto.toEntity(verbTense: String): VerbEntity {
    return VerbEntity(
        number = number,
        infinitive = infinitive,
        type = type,
        translation = translation,
        verbTense = verbTense,
    )
}

fun VerbDto.toConjugationEntities(verbId: Long): ConjugationEntities {
    return ConjugationEntities(
        iConjugation =
            IConjugationEntity(
                verbId = verbId,
                example = conjugations.i.example,
                form = conjugations.i.form,
            ),
        youInformalConjugation =
            YouInformalConjugationEntity(
                verbId = verbId,
                example = conjugations.youInformal.example,
                form = conjugations.youInformal.form,
            ),
        heSheYouFormalConjugation =
            HeSheYouFormalConjugationEntity(
                verbId = verbId,
                example = conjugations.heSheYouFormal.example,
                form = conjugations.heSheYouFormal.form,
            ),
        weConjugation =
            WeConjugationEntity(
                verbId = verbId,
                example = conjugations.we.example,
                form = conjugations.we.form,
            ),
        youPluralInformalConjugation =
            YouPluralInformalConjugationEntity(
                verbId = verbId,
                example = conjugations.youPluralInformal.example,
                form = conjugations.youPluralInformal.form,
            ),
        theyYouPluralConjugation =
            TheyYouPluralConjugationEntity(
                verbId = verbId,
                example = conjugations.theyYouPlural.example,
                form = conjugations.theyYouPlural.form,
            ),
    )
}

/** Classe auxiliar para agrupar todas as conjugações de um verbo */
data class ConjugationEntities(
    val iConjugation: IConjugationEntity,
    val youInformalConjugation: YouInformalConjugationEntity,
    val heSheYouFormalConjugation: HeSheYouFormalConjugationEntity,
    val weConjugation: WeConjugationEntity,
    val youPluralInformalConjugation: YouPluralInformalConjugationEntity,
    val theyYouPluralConjugation: TheyYouPluralConjugationEntity,
)

/** Converte VerbWithConjugations de volta para VerbDto */
fun VerbWithConjugations.toDto(): VerbDto {
    return VerbDto(
        number = verb.number,
        infinitive = verb.infinitive,
        type = verb.type,
        translation = verb.translation,
        conjugations =
            PersonConjugationsDto(
                i =
                    IConjugationDto(
                        example = iConjugation.firstOrNull()?.example,
                        form = iConjugation.firstOrNull()?.form ?: "",
                    ),
                youInformal =
                    YouInformalConjugationDto(
                        example = youInformalConjugation.firstOrNull()?.example,
                        form = youInformalConjugation.firstOrNull()?.form ?: "",
                    ),
                heSheYouFormal =
                    HeSheYouFormalConjugationDto(
                        example = heSheYouFormalConjugation.firstOrNull()?.example,
                        form = heSheYouFormalConjugation.firstOrNull()?.form ?: "",
                    ),
                we =
                    WeConjugationDto(
                        example = weConjugation.firstOrNull()?.example,
                        form = weConjugation.firstOrNull()?.form ?: "",
                    ),
                youPluralInformal =
                    YouPluralInformalConjugationDto(
                        example = youPluralInformalConjugation.firstOrNull()?.example,
                        form = youPluralInformalConjugation.firstOrNull()?.form ?: "",
                    ),
                theyYouPlural =
                    TheyYouPluralConjugationDto(
                        example = theyYouPluralConjugation.firstOrNull()?.example,
                        form = theyYouPluralConjugation.firstOrNull()?.form ?: "",
                    ),
            ),
    )
}
