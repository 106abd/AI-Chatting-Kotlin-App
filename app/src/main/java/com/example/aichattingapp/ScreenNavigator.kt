package com.example.aichattingapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenNavigator(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.screen_WELCOME
    ) {

        composable(route = Routes.screen_WELCOME) { backStackEntry ->
            Welcome(
                modifier = modifier,
                navController = navController
            )
        }

        composable(route = Routes.screen_CHAT) { backStackEntry ->
            Chat(
                modifier = modifier,
                navController = navController
            )
        }

    }
}