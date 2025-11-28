package com.helvio.laconjugacion.presentation.selectVerbalTense.model

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helvio.laconjugacion.domain.usecase.GetConjugationsFromJsonUseCase
import com.helvio.laconjugacion.presentation.MainActivity.Companion.dataStore
import kotlinx.coroutines.launch

class SelectVerbalTenseViewModel(
    val getConjugationsFromJsonUseCase: GetConjugationsFromJsonUseCase
) : ViewModel() {

    fun getConjugationsFromJsonIfNeeded(context: Context) {
        viewModelScope.launch {
            context.dataStore.apply {
                data.collect { prefs ->
                    val hasGetAllConjugationsFromJson = prefs[HAS_GET_ALL_CONJUGATION_FROM_JSON]

                    if (hasGetAllConjugationsFromJson != true) {
                        getConjugationsFromJsonUseCase(context)
                        edit { prefs -> prefs[HAS_GET_ALL_CONJUGATION_FROM_JSON] = true }
                    }
                }
            }
        }
    }

    companion object {
        val HAS_GET_ALL_CONJUGATION_FROM_JSON =
            booleanPreferencesKey("hasGetAllConjugationsFromJson")
    }
}
