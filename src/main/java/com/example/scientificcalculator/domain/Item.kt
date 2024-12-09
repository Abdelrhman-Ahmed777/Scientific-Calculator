package com.example.scientificcalculator.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 ,
    val problem: String ,
    val answer: String ,
    val date: String = LocalDate.now().toString() ,
    val time: String = currentTime()
)
