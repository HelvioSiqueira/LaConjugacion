package com.helvio.laconjugacion.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.helvio.laconjugacion.domain.repository.IConjugationRepository
import com.helvio.laconjugacion.presentation.navigation.MyNavHost
import com.helvio.laconjugacion.presentation.theme.LaConjugacionTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    val conjugationRepository by inject<IConjugationRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        actionBar?.hide()

        setContent {
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                context.dataStore.apply {
                    data.collect { prefs ->
                        val hasGetAllConjugationsFromJson =
                            prefs[booleanPreferencesKey("hasGetAllConjugationsFromJson")]

                        if (hasGetAllConjugationsFromJson != true) {
                            conjugationRepository.getAllConjugations(context)
                            edit { prefs ->
                                prefs[booleanPreferencesKey("hasGetAllConjugationsFromJson")] = true
                            }
                        }
                    }
                }
            }

            LaConjugacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(top = innerPadding.calculateTopPadding())) {
                        val navHostController = rememberNavController()

                        MyNavHost(navHostController)
                    }
                }
            }
        }
    }
}
