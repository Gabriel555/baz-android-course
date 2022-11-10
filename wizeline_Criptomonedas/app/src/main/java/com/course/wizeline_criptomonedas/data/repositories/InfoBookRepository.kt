package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookProvider
import com.course.wizeline_criptomonedas.data.network.InfoBookService

class InfoBookRepository {

    private val api = InfoBookService()

    suspend fun getInfoBooks(book : String) : InfoBookModel {
        val response: InfoBookModel = api.getInfoBooks(book = book)
        InfoBookProvider.infoBook = response
        return response
    }
}