package com.helvio.laconjugacion

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
import androidx.navigation.compose.rememberNavController
import com.helvio.laconjugacion.repository.conjugation.IConjugationRepository
import com.helvio.laconjugacion.ui.routes.MyNavHost
import com.helvio.laconjugacion.ui.theme.LaConjugacionTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val conjugationRepository by inject<IConjugationRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        actionBar?.hide()

        setContent {
            val context = LocalContext.current

            LaunchedEffect(Unit) { conjugationRepository.getAllConjugations(context) }

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
