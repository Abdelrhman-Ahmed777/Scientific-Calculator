package com.example.scientificcalculator.presention.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.scientificcalculator.presention.ui.MainCalculatorScreen


fun NavGraphBuilder.home(navController: NavHostController) {
    navigation(
        route = Screens.MainScreensGraph.route,
        startDestination = Screens.CalculatorScreen.route
    ){
        composable(route = Screens.CalculatorScreen.route) {
            MainCalculatorScreen(navController)
        }
    }
}

