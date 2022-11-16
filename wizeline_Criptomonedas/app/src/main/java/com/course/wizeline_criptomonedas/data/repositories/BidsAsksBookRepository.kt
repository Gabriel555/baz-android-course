package com.course.wizeline_criptomonedas.data.repositories

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.model.BidsAsksBookProvider
import com.course.wizeline_criptomonedas.data.network.BidsAsksBookService
import javax.inject.Inject

class BidsAsksBookRepository @Inject constructor(
    private val api: BidsAsksBookService,
    private val bidsAsksBookProvider: BidsAsksBookProvider
) {
    suspend fun getBidsAsksBooks(book: String): BidsAsksBookModel {
        val response: BidsAsksBookModel = api.getBidsAsksBooks(book = book)
        bidsAsksBookProvider.bidsAsksBook = response
        return response
    }
}
