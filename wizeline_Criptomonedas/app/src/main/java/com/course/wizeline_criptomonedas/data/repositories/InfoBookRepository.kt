package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookProvider
import com.course.wizeline_criptomonedas.data.network.InfoBookService
import javax.inject.Inject

class InfoBookRepository @Inject constructor(
    private val api : InfoBookService,
    private val infobookProvider: InfoBookProvider
){
    suspend fun getInfoBooks(book : String) : InfoBookModel {
        val response: InfoBookModel = api.getInfoBooks(book = book)
        infobookProvider.infoBook = response
        return response
    }
}