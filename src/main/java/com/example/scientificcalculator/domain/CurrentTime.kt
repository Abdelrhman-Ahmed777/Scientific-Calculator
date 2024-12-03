package com.example.scientificcalculator.domain

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
fun currentTime() : String {
    val currentTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("hh:mm: a")
    return currentTime.format(formatter)
}

