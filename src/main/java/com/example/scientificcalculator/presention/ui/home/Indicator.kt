package com.example.scientificcalculator.presention.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.scientificcalculator.ui.theme.lightBlue

@Composable
fun DotIndicator(
    totalDots: Int ,
    selectedIndex: Int ,
    selectedColor: Color = lightBlue ,
    unselectedColor: Color = Color.Gray ,
    dotSize: Dp = 8.dp ,
    dotSpacing: Dp = 8.dp , modifier: Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(dotSpacing) ,
       verticalAlignment = Alignment.CenterVertically ,
        modifier = modifier
    ) {
        items(totalDots) { index ->
            Box(
                modifier = Modifier
                    .size(dotSize)
                    .clip(CircleShape)
                    .background(if (index == selectedIndex) selectedColor else unselectedColor)
            )
        }
    }
}