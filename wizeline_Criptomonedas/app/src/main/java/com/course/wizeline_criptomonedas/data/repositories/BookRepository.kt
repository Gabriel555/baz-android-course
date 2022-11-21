package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.database.dao.BookDao
import com.course.wizeline_criptomonedas.data.database.entities.CryptoEntity
import com.course.wizeline_criptomonedas.data.model.BookModel
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.data.network.BookService
import com.course.wizeline_criptomonedas.domain.model.Crypto
import com.course.wizeline_criptomonedas.domain.model.toDomain
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val api: BookService,
    private val bookDao: BookDao
) {
    suspend fun getAllBooksFromApi(): Single<List<CryptoModel>> {
        val response: Single<BookModel> = api.getBooks()
        return response.map {
            it.crypto
        }
    }

    suspend fun getAllBooksFromDatabase(): List<Crypto> {
        val response = bookDao.getAllBooks()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertBooks(crypto: List<CryptoEntity>) {
        bookDao.insertAll(crypto)
    }

    suspend fun clearCryptos() {
        bookDao.deleteAllQuotes()
    }
}
