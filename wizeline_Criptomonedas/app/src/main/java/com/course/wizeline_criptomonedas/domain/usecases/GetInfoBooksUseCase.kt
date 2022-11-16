package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.repositories.InfoBookRepository
import javax.inject.Inject

class GetInfoBooksUseCase @Inject constructor(
    private val repository: InfoBookRepository
) {
    suspend operator fun invoke(book: String): InfoBookModel = repository.getInfoBooks(book = book)
}
