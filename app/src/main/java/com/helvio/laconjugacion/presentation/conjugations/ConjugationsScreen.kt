package com.helvio.laconjugacion.presentation.conjugations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.helvio.laconjugacion.domain.model.ConjugationsModel
import com.helvio.laconjugacion.domain.model.GetConjugationResult
import com.helvio.laconjugacion.domain.model.dto.VerbDto
import com.helvio.laconjugacion.presentation.conjugations.model.ConjugationsScreenState
import com.helvio.laconjugacion.presentation.theme.LaConjugacionTheme

@Composable
fun ConjugationsScreen(state: ConjugationsScreenState) {

    Scaffold { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
        ) {
            when (val state = state.getConjugationResult) {
                is GetConjugationResult.Loading -> {
                    LoadingState()
                }
                is GetConjugationResult.Success -> {
                    SuccessState(conjugationsModel = state.data)
                }
                is GetConjugationResult.Failure -> {
                    ErrorState(errorMessage = state.errorMessage)
                }
            }
        }
    }
}

@Composable
private fun LoadingState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun SuccessState(conjugationsModel: ConjugationsModel) {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(conjugationsModel.verbs) { verb -> VerbCard(verb = verb) }
        }
    }
}

@Composable
private fun VerbCard(verb: VerbDto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = verb.infinitive,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            Text(
                text = "Tradução: ${verb.translation}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp),
            )

            Text(
                text = "Tipo: ${verb.type}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(top = 4.dp),
            )

            // Conjugações
            Column(modifier = Modifier.padding(top = 12.dp)) {
                ConjugationRow("Yo", verb.conjugations.i.form, verb.conjugations.i.example)
                ConjugationRow(
                    "Tú",
                    verb.conjugations.youInformal.form,
                    verb.conjugations.youInformal.example,
                )
                ConjugationRow(
                    "Él/Ella/Usted",
                    verb.conjugations.heSheYouFormal.form,
                    verb.conjugations.heSheYouFormal.example,
                )
                ConjugationRow(
                    "Nosotros/Nosotras",
                    verb.conjugations.we.form,
                    verb.conjugations.we.example,
                )
                ConjugationRow(
                    "Vosotros/Vosotras",
                    verb.conjugations.youPluralInformal.form,
                    verb.conjugations.youPluralInformal.example,
                )
                ConjugationRow(
                    "Ellos/Ellas/Ustedes",
                    verb.conjugations.theyYouPlural.form,
                    verb.conjugations.theyYouPlural.example,
                )
            }
        }
    }
}

@Composable
private fun ConjugationRow(pronoun: String, form: String, example: String?) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = "$pronoun: $form", style = MaterialTheme.typography.bodyMedium)
        example?.let {
            Text(
                text = "    Ex: $it",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun ErrorState(errorMessage: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Erro ao carregar conjugações",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.error,
            )
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp),
            )
        }
    }
}

@Preview
@Composable
fun ConjugationsScreenPreview() {
    LaConjugacionTheme {
        ConjugationsScreen(
            ConjugationsScreenState(
                getConjugationResult = GetConjugationResult.Success(ConjugationsModel())
            )
        )
    }
}
