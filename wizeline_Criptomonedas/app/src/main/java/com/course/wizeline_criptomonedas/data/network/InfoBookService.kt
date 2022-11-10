package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.core.RetrofitHelper
import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class InfoBookService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getInfoBooks(book:String): InfoBookModel {
        return withContext(Dispatchers.IO){
            val response: Response<InfoBookModel> = retrofit.create(
                BookApiClient::class.java).getInfoBooks(book = book)
            response.body()!!
        }

    }
}