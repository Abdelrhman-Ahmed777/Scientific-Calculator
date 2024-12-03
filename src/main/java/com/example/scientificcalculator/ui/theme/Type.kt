package com.example.scientificcalculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.scientificcalculator.R
import com.example.scientificcalculator.R.font.digital7italic658
import com.example.scientificcalculator.R.font.digital7mono94
import com.example.scientificcalculator.R.font.digital7rg1ml

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default ,
        fontWeight = FontWeight.Normal ,
        fontSize = 16.sp ,
        lineHeight = 24.sp ,
        letterSpacing = 0.5.sp
    ) ,


    titleLarge = TextStyle(
        fontFamily = FontFamily.Default ,
        fontWeight = FontWeight.Normal ,
        fontSize = 22.sp ,
        lineHeight = 28.sp ,
        letterSpacing = 0.sp
    ) ,
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default ,
        fontWeight = FontWeight.Medium ,
        fontSize = 11.sp ,
        lineHeight = 16.sp ,
        letterSpacing = 0.5.sp
    )
)

val digital = FontFamily(
Font(digital7rg1ml) ,
Font(digital7italic658) ,
Font(digital7mono94)
)