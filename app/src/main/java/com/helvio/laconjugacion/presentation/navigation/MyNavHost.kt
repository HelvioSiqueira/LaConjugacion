package com.helvio.laconjugacion.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.helvio.laconjugacion.domain.model.VerbTenseEnum
import com.helvio.laconjugacion.presentation.conjugations.ConjugationsScreen
import com.helvio.laconjugacion.presentation.conjugations.ConjugationsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MyNavHost(navHostController: NavHostController) {

    NavHost(navHostController, startDestination = NavPages.SelectVerbalTense) {
        composable<NavPages.SelectVerbalTense> {}

        composable<NavPages.ConjugationsPage> {
            val viewModel = koinViewModel<ConjugationsViewModel>()
            viewModel.loadConjugations(VerbTenseEnum.PRESENT_INDICATIVE)

            val state by viewModel.conjugationsState.collectAsStateWithLifecycle()

            ConjugationsScreen(state)
        }
    }
}
