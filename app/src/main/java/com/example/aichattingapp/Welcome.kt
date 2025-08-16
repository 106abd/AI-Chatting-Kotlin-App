package com.example.aichattingapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun Welcome(modifier: Modifier = Modifier, navController: NavController) {

    val viewModel: WelcomeViewModel = viewModel()
    val inputText by viewModel.textInput

    LaunchedEffect(Unit) {
        viewModel.validNavigation.collect { canNavigate ->

            if (canNavigate) {
                navController.navigate(route = Routes.screen_CHAT + "?inputText=${inputText}")
            }
        }
    }

    Box(
        modifier = modifier.fillMaxSize().padding(horizontal = 30.dp, vertical = 20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding().padding(20.dp)
        ) {

            // Welcome message
            Text(
                text = stringResource(R.string.welcome_label),
                textAlign = TextAlign.Center
            )

            // Text Input
            OutlinedTextField(
                value = inputText,
                onValueChange = { viewModel.onTextChange(it) },
                placeholder = { Text(stringResource(R.string.welcome_hint)) },
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.Green),
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp)
            )
        }

        // Start Chatting Button
        Button(
            onClick = { viewModel.onButtonClick(inputText = inputText) },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Green),
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.welcome_button)
            )
        }
    }
}