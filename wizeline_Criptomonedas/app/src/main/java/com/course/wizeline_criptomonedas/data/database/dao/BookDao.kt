package com.course.wizeline_criptomonedas.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.course.wizeline_criptomonedas.data.database.entities.CryptoEntity

@Dao
interface BookDao {

    @Query("SELECT * FROM crypto_table ORDER BY book DESC")
    suspend fun getAllBooks(): List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(books: List<CryptoEntity>)

    @Query("DELETE FROM crypto_table")
    suspend fun deleteAllQuotes()
}
