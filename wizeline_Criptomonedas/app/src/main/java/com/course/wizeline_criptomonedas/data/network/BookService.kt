package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.BookModel
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookService @Inject constructor(
    private val retrofit: BookApiClient
) {

    suspend fun getBooks(): Single<BookModel> {
        return withContext(Dispatchers.IO) {
            val response: Single<BookModel> = retrofit.getAllBooks()
            response
        }
    }
}
