package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.BookModel
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class BookService @Inject constructor(
    private val retrofit: BookApiClient
){

    suspend fun getBooks(): List<CryptoModel>{
        return withContext(Dispatchers.IO){
            val response: Response<BookModel> = retrofit.getAllBooks()
            response.body()?.crypto ?: emptyList()
        }

    }
}