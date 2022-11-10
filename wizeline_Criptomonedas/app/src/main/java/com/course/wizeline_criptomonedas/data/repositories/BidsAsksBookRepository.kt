package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.model.BidsAsksBookProvider
import com.course.wizeline_criptomonedas.data.network.BidsAsksBookService

class BidsAsksBookRepository {

    private val api = BidsAsksBookService()

    suspend fun getBidsAsksBooks(book : String) : BidsAsksBookModel {
        val response: BidsAsksBookModel = api.getBidsAsksBooks(book = book)
        BidsAsksBookProvider.bidsAsksBook = response
        return response
    }
}