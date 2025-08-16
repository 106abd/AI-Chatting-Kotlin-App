package com.example.aichattingapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class WelcomeViewModel : ViewModel() {

    private val _validNavigation = MutableSharedFlow<Boolean>()
    val validNavigation = _validNavigation.asSharedFlow()

    private val _textInput = mutableStateOf("")
    val textInput: State<String> get() = _textInput

    fun onTextChange(newText: String) {
        _textInput.value = newText
    }

    fun onButtonClick(inputText: String) {

        val cleanedInput = inputText.trim()
        if (cleanedInput.isNotEmpty()) {
            _textInput.value = ""
            viewModelScope.launch(Dispatchers.Main) { _validNavigation.emit(true) }
        }
    }
}