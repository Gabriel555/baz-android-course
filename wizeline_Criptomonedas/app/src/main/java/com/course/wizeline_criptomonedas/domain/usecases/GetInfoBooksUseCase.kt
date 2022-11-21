package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.model.InfoModel
import com.course.wizeline_criptomonedas.data.repositories.InfoBookRepository
import javax.inject.Inject

class GetInfoBooksUseCase @Inject constructor(
    private val repository: InfoBookRepository
) {
    suspend operator fun invoke(book: String): InfoBookModel? = try {
        repository.getInfoBooks(book = book)
    } catch (e: Exception) {
        InfoBookModel(
            "",
            InfoModel("", "", "", "", "", "")
        )
    }
}
