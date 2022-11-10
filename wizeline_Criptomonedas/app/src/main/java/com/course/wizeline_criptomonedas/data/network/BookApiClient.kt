package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.model.BookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiClient {

    @GET("available_books")
    suspend fun getAllBooks():Response<BookModel>

    @GET("ticker/")
    suspend fun getInfoBooks(@Query("book") book: String): Response<InfoBookModel>

    @GET("order_book/")
    suspend fun getBidsAsksBooks(@Query("book") book: String):Response<BidsAsksBookModel>

}