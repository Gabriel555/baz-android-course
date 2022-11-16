package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.model.BookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.utils.endpoints.END_BIDS_ASKS_BOOKS
import com.course.wizeline_criptomonedas.data.utils.endpoints.END_BOOKS
import com.course.wizeline_criptomonedas.data.utils.endpoints.END_INFO_BOOKS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiClient {

    @GET(END_BOOKS)
    suspend fun getAllBooks(): Response<BookModel>

    @GET(END_INFO_BOOKS)
    suspend fun getInfoBooks(@Query("book") book: String): Response<InfoBookModel>

    @GET(END_BIDS_ASKS_BOOKS)
    suspend fun getBidsAsksBooks(@Query("book") book: String): Response<BidsAsksBookModel>
}
