package com.example.scientificcalculator.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.scientificcalculator.domain.Item
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Item::class] , version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        @Volatile
        var instance: DataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): DataBase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext ,
                    DataBase::class.java ,
                    "database"
                ).build()
                instance = newInstance
                newInstance
            }

        }

    }

}