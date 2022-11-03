package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.model.BookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import retrofit2.Response
import retrofit2.http.GET

interface BookApiClient {
    @GET("available_books")
    suspend fun getAllBooks():Response<BookModel>

    @GET("ticker/?book=btc_mxn")
    suspend fun getInfoBooks():Response<InfoBookModel>

    @GET("order_book/?book=btc_mxn")
    suspend fun getBidsAsksBooks():Response<BidsAsksBookModel>
}