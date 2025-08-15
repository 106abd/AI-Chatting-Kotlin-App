package com.example.aichattingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.aichattingapp.ui.theme.AIChattingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]
        val welcomeViewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            AIChattingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Chat(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = chatViewModel
                    )

//                    Welcome(
//                        modifier = Modifier.padding(innerPadding),
//                        viewModel = welcomeViewModel
//                    )
                }
            }
        }
    }
}
