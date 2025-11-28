package com.helvio.laconjugacion.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.helvio.laconjugacion.presentation.conjugations.ConjugationsScreen
import com.helvio.laconjugacion.presentation.conjugations.ConjugationsViewModel
import com.helvio.laconjugacion.presentation.selectVerbalTense.SelectVerbalTenseScreen
import com.helvio.laconjugacion.presentation.selectVerbalTense.model.SelectVerbalTenseState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MyNavHost(navHostController: NavHostController) {

    NavHost(navHostController, startDestination = NavPages.SelectVerbalTense) {
        composable<NavPages.SelectVerbalTense> {
            val state =
                SelectVerbalTenseState(
                    onVerbalTenseSelected = { verbalTenseEnum ->
                        navHostController.navigate(NavPages.ConjugationsPage(verbalTenseEnum))
                    }
                )

            SelectVerbalTenseScreen(state)
        }

        composable<NavPages.ConjugationsPage> {
            val viewModel = koinViewModel<ConjugationsViewModel>()

            val args = it.toRoute<NavPages.ConjugationsPage>()

            LaunchedEffect(Unit) { viewModel.loadConjugations(args.verbalTense) }

            val state by viewModel.conjugationsState.collectAsStateWithLifecycle()

            ConjugationsScreen(state)
        }
    }
}
