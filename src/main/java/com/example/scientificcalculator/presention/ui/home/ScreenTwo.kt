package com.example.scientificcalculator.presention.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SinesScreen() {
    Box(Modifier.fillMaxSize()) {
        Text("Sines Screen" , fontSize = 32.sp , modifier = Modifier.align(Alignment.Center))
    }
}
