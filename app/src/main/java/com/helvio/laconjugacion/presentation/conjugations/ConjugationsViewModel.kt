package com.helvio.laconjugacion.presentation.conjugations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helvio.laconjugacion.domain.model.GetConjugationResult
import com.helvio.laconjugacion.domain.model.VerbalTenseEnum
import com.helvio.laconjugacion.domain.usecase.GetConjugationsUseCase
import com.helvio.laconjugacion.presentation.conjugations.model.ConjugationsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ConjugationsViewModel(private val getConjugationsUseCase: GetConjugationsUseCase) :
    ViewModel() {

    private val _conjugationsState =
        MutableStateFlow(ConjugationsScreenState(GetConjugationResult.Loading))
    val conjugationsState: StateFlow<ConjugationsScreenState> = _conjugationsState.asStateFlow()

    fun loadConjugations(verbTense: VerbalTenseEnum) {
        viewModelScope.launch {
            getConjugationsUseCase(verbTense).collect { result ->
                _conjugationsState.update { it.copy(result) }
            }
        }
    }
}
