package br.uepa.aplicativoteste1.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MarianaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MarianaUiState())
    val uiState: StateFlow<MarianaUiState> = _uiState

    fun onValueTextFieldChange(newValue: String) {
        _uiState.value = uiState.value.copy(valorTextField = newValue)
    }
    fun onExibirTextoChange(newValue: Boolean) {
        _uiState.value = uiState.value.copy(exibirTexto = newValue)
    }
}