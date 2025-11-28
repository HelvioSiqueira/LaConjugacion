package com.helvio.laconjugacion.ui.conjugations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helvio.laconjugacion.datasource.model.VerbTenseEnum
import com.helvio.laconjugacion.domain.usecase.GetConjugationsUseCase
import com.helvio.laconjugacion.repository.model.GetConjugationResult
import com.helvio.laconjugacion.ui.model.ConjugationsScreenState
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

    fun loadConjugations(verbTense: VerbTenseEnum) {
        viewModelScope.launch {
            getConjugationsUseCase(verbTense).collect { result ->
                _conjugationsState.update { it.copy(result) }
            }
        }
    }
}
