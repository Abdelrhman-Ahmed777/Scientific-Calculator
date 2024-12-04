package com.example.scientificcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.scientificcalculator.presention.navigation.MyApp
import com.example.scientificcalculator.ui.theme.ScientificCalculatorTheme
import java.security.Permission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScientificCalculatorTheme {
                val navController = rememberNavController()

                MyApp(navController)
            }
        }
    }
}

