package com.example.aichattingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Chat(modifier: Modifier = Modifier, navController: NavController) {

    val viewModel: ChatViewModel = viewModel()

    val inputText by viewModel.textInput
    val chatLog = viewModel.chatLog
    val listState = rememberLazyListState()

    // Automate scroll when new message is added
    LaunchedEffect(chatLog.size) {
        if (chatLog.isNotEmpty()) {
            listState.animateScrollToItem(chatLog.lastIndex)
        }
    }

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text List Renderer
        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f).fillMaxWidth().padding(top = 10.dp)
        ) {
            itemsIndexed(chatLog) { index: Int, textMessage: String ->
                TextLog(
                    textMessage = textMessage,
                    index = index
                )
            }
        }

        // Text Input Functionality
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 30.dp, start = 10.dp, end = 10.dp)
        ) {

            // Chatbox
            OutlinedTextField(
                value = inputText,
                onValueChange = {viewModel.onTextChange(it)},
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Green),
                modifier = Modifier.weight(1f)
                    .padding(end = 10.dp)
                )

            // Send Text Button
            IconButton(
                onClick = { viewModel.onSendMessage(inputText)},
                modifier = Modifier.size(55.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(color = Color.Green)


            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_add_comment_24),
                    contentDescription = "Send",
                    tint = Color.Black
                )
            }

        }
    }

}

// Composable for each sent text message
@Composable
fun TextLog(modifier: Modifier = Modifier, textMessage: String, index: Int) {

    var startPadding = 10
    var endPadding = 60
    var rowGravity = Arrangement.Start
    var rowColor = Color.DarkGray
    var textColor = Color.White

    if (index % 2 != 0) {
        startPadding = 60
        endPadding = 10
        rowGravity = Arrangement.End
        rowColor = Color.Green
        textColor = Color.Black
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = startPadding.dp, end = endPadding.dp, top = 10.dp, bottom = 10.dp),
        horizontalArrangement = rowGravity
    ) {
        Text(
            text = textMessage,
            color = textColor,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(rowColor)
                .padding(10.dp)
        )
    }
}