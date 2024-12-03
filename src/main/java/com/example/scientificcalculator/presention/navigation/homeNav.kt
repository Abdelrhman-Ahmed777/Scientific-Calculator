package com.example.scientificcalculator.presention.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.scientificcalculator.presention.ui.home.MainCalculatorScreen


fun NavGraphBuilder.home(navController: NavHostController) {
    navigation(
        route = Screens.MainScreensGraph.route,
        startDestination = Screens.CalculatorScreen.route
    ){

    }
}

