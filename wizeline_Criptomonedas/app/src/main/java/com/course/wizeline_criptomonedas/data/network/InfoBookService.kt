package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class InfoBookService @Inject constructor(
    private val retrofit: BookApiClient
) {
    suspend fun getInfoBooks(book:String): InfoBookModel {
        return withContext(Dispatchers.IO){
            val response: Response<InfoBookModel> = retrofit.getInfoBooks(book = book)
            response.body()!!
        }

    }
}