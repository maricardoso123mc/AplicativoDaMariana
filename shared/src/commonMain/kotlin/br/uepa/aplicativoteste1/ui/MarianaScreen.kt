package br.uepa.aplicativoteste1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonShapes
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.uepa.aplicativoteste1.viewmodel.MarianaViewModel

@Composable
fun MarianaScreen(modifier: Modifier) {
    val marianaViewModel: MarianaViewModel = viewModel()
    val marianaUiState by marianaViewModel.uiState.collectAsState()

    Column (
        modifier = modifier.fillMaxSize().background(Color.White),
    ){
        Text(text = "MARIANA", modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "SEJA AMIGO DA MARIANA", modifier = Modifier.padding(bottom = 16.dp))
        TextField(value = marianaUiState.valorTextField, onValueChange = { marianaViewModel.onValueTextFieldChange(it) })
        Button(
            onClick = {
            marianaViewModel.onExibirTextoChange(true)
            },
            shapes = ButtonShapes(shape = RectangleShape, pressedShape = RectangleShape),
        ) {
            Text(text = "VIRAR FRIEND")
        }
        if (marianaUiState.exibirTexto) {
            Text(text = marianaUiState.valorTextField)
        }
    }
}

@Preview
@Composable
fun MarianaScreenPreview() {
    MarianaScreen(modifier = Modifier)
}