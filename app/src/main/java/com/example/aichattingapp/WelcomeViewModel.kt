package com.example.aichattingapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _textInput = mutableStateOf("")
    val textInput: State<String> get() = _textInput

    fun onTextChange(newText: String) {
        _textInput.value = newText
    }

    fun onButtonClick() {

    }

}