package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class BidsAsksBookService @Inject constructor(
    private val retrofit: BookApiClient
) {

    suspend fun getBidsAsksBooks(book: String): BidsAsksBookModel {
        return withContext(Dispatchers.IO) {
            val response: Response<BidsAsksBookModel> = retrofit.getBidsAsksBooks(book = book)
            response.body()!!
        }
    }
}
