package com.course.wizeline_criptomonedas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.course.wizeline_criptomonedas.data.database.dao.BookDao
import com.course.wizeline_criptomonedas.data.database.entities.CryptoEntity

@Database(entities = [CryptoEntity::class], version = 1)
abstract class BookDatabase: RoomDatabase() {

    abstract fun getBookDao(): BookDao
}