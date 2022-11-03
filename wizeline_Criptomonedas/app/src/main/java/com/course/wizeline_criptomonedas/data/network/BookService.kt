package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.core.RetrofitHelper
import com.course.wizeline_criptomonedas.data.model.BookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BookService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBooks(): BookModel{
        return withContext(Dispatchers.IO){
            val response: Response<BookModel> = retrofit.create(BookApiClient::class.java).getAllBooks()
            response.body()!!
        }

    }
}