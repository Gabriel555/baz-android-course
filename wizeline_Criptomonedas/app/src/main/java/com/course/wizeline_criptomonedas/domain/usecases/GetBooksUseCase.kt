package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.data.repositories.BookRepository

class GetBooksUseCase {

    private val repository = BookRepository()

    suspend operator fun invoke(): List<CryptoModel> {
        val resultBooksFilter = mutableListOf<CryptoModel>()
        if (!repository.getAllBooks().isNullOrEmpty()){
            repository.getAllBooks().forEach {
                if (it.book.contains("mxn")){
                    resultBooksFilter.add(it)
                }
            }
        }
        return resultBooksFilter
    }
}