package com.example.scientificcalculator.domain

import com.example.scientificcalculator.model.db.DataBase
import kotlinx.coroutines.flow.Flow

class Repository(private val db: DataBase) {
    suspend fun insert(item: Item) {
        db.dao().insert(item)
    }
     fun getAll(): Flow<List<Item>> {
        return db.dao().getAll()
    }
}
