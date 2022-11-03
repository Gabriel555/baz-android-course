package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.model.BookModel
import com.course.wizeline_criptomonedas.data.model.BookProvider
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.data.network.BookService

class BookRepository {

    private val api = BookService()

    suspend fun getAllBooks() : List<CryptoModel> {
        val response: BookModel = api.getBooks()
        BookProvider.books = response
        return response.crypto
    }
}