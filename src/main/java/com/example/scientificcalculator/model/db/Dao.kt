package com.example.scientificcalculator.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.scientificcalculator.domain.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert
    suspend fun insert(item: Item)

    @Query("SELECT * FROM Item")
     fun getAll(): Flow<List<Item>>

}