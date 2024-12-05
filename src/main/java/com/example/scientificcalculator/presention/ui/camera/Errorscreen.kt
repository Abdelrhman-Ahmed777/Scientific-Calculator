package com.example.scientificcalculator.presention.ui.camera

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ErrorScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ){
        Text(
            text = "Error",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}