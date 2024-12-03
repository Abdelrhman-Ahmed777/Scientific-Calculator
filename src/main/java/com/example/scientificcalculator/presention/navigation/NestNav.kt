package com.example.scientificcalculator.presention.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NestedNavgationGraph(navController: NavHostController) {
    NavHost(
        navController = navController ,
        startDestination = Screens.MainScreensGraph.route
    ) {
        home(navController = navController)
        aiAssistant(navController = navController)
        history(navController = navController)
        settings(navController = navController)

    }
}
