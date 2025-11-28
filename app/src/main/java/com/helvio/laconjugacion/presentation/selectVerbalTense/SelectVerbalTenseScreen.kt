package com.helvio.laconjugacion.presentation.selectVerbalTense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.helvio.laconjugacion.domain.model.VerbalTenseEnum
import com.helvio.laconjugacion.domain.model.getVerbalTenseString
import com.helvio.laconjugacion.presentation.selectVerbalTense.model.SelectVerbalTenseState
import com.helvio.laconjugacion.presentation.theme.LaConjugacionTheme

@Composable
fun SelectVerbalTenseScreen(state: SelectVerbalTenseState) {
    Scaffold { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding()),
        ) {
            LazyColumn {
                items(VerbalTenseEnum.entries) { verbalTense ->
                    VerbalTenseButton(
                        verbalTense = verbalTense,
                        onClicked = { state.onVerbalTenseSelected(verbalTense) },
                    )
                }
            }
        }
    }
}

@Composable
private fun VerbalTenseButton(verbalTense: VerbalTenseEnum, onClicked: (VerbalTenseEnum) -> Unit) {
    Button(onClick = { onClicked(verbalTense) }, modifier = Modifier.width(200.dp)) {
        Text(
            text = stringResource(verbalTense.getVerbalTenseString()),
            textAlign = TextAlign.Center,
            lineHeight = 15.sp,
        )
    }
}

@Preview
@Composable
private fun SelectVerbalTenseScreenPreview() {
    LaConjugacionTheme {
        SelectVerbalTenseScreen(SelectVerbalTenseState(onVerbalTenseSelected = {}))
    }
}
