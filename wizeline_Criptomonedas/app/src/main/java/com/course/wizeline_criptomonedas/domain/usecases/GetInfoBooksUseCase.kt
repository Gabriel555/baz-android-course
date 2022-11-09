package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.repositories.InfoBookRepository

class GetInfoBooksUseCase {

    private val repository = InfoBookRepository()

    suspend operator fun invoke(book : String) : InfoBookModel = repository.getInfoBooks(book = book)

}