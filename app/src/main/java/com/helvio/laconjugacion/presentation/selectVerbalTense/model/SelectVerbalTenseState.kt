package com.helvio.laconjugacion.presentation.selectVerbalTense.model

import com.helvio.laconjugacion.domain.model.VerbalTenseEnum

data class SelectVerbalTenseState(val onVerbalTenseSelected: (VerbalTenseEnum) -> Unit)
