package com.example.aichattingapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {

    private val _textInput = mutableStateOf("")
    val textInput: State<String> get() = _textInput

    private val _chatLog = mutableStateListOf<String>()
    val chatLog: List<String> = _chatLog

    fun onTextChange(text: String) {
        _textInput.value = text
    }

    fun onSendMessage(text: String) {

        val removedSpace = text.trim()

        if (!removedSpace.isEmpty()) {
            val trimmedText = text.trimEnd()
            _chatLog.add(trimmedText)
        }

        _textInput.value = ""
    }

    fun generateChatMessages() {
        _chatLog.add("Hi")
        _chatLog.add("Hello")
        _chatLog.add("Goodbye")
        _chatLog.add("See you later")
    }
}