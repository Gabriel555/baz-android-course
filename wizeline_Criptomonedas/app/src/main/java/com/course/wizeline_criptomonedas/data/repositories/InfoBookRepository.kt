package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.model.InfoBookProvider
import com.course.wizeline_criptomonedas.data.network.InfoBookService

class InfoBookRepository {

    private val api = InfoBookService()

    suspend fun getInfoBooks() : InfoBookModel {
        val response: InfoBookModel = api.getInfoBooks()
        InfoBookProvider.infoBook = response
        return response
    }
}