package com.example.scientificcalculator.presention.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.scientificcalculator.presention.ui.ai.MainAiChat
import com.example.scientificcalculator.presention.ui.camera.CameraMainFun
import com.example.scientificcalculator.presention.ui.camera.ErrorScreen
import com.example.scientificcalculator.presention.ui.home.MainCalculatorScreen

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun NestedNavgationGraph(
    navController: NavHostController ,

    ) {
    NavHost(
        navController = navController ,
        startDestination = Screens.CalculatorScreen.route
    ) {
        composable(route = Screens.CalculatorScreen.route) {
            MainCalculatorScreen(navController)
        }
        composable(route = Screens.AiAssistantScreen.route) {
            MainAiChat(navController = navController)
        }
        composable(Screens.CameraScreen.route) {
            CameraMainFun(navController)
        }
        composable(Screens.Error.route) {
            ErrorScreen(navController)
        }
    }
}
