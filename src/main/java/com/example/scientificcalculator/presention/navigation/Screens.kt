package com.example.scientificcalculator.presention.navigation

sealed class Screens(val route: String) {
    data object CalculatorScreen : Screens("calculator_screen")
    data object AiAssistantScreen : Screens("ai_assistant_screen")
    data object HistoryScreen : Screens("history_screen")
    data object SettingsScreen : Screens("settings_screen")
    data object Error : Screens("error_screen")
    data object CameraScreen : Screens("camera_screen")
    // graphs route and
    data object MainScreensGraph : Screens("main_screen")

}