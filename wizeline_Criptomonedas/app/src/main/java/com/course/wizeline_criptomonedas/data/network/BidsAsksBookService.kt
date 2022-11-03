package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.core.RetrofitHelper
import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BidsAsksBookService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBidsAsksBooks(): BidsAsksBookModel {
        return withContext(Dispatchers.IO){
            val response: Response<BidsAsksBookModel> = retrofit.create(BookApiClient::class.java).getBidsAsksBooks()
            response.body()!!
        }

    }
}