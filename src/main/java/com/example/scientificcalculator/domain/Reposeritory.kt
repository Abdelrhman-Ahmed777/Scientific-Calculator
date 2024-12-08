package com.example.scientificcalculator.model.db

import com.example.scientificcalculator.domain.Item

class Repository(private val db: DataBase) {
    suspend fun insert(item: Item) {
        db.dao().insert(item)
    }
    suspend fun getAll(): List<Item> {
        return db.dao().getAll()
    }
}
