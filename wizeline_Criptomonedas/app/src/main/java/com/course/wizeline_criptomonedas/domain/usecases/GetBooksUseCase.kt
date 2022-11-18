package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.database.entities.toDatabase
import com.course.wizeline_criptomonedas.data.repositories.BookRepository
import com.course.wizeline_criptomonedas.domain.model.Crypto
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(): List<Crypto> {
        val cryptos: List<Crypto>? = try { repository.getAllBooksFromApi() } catch (e: Exception) { emptyList() }

        return if (!cryptos.isNullOrEmpty()) {
            repository.clearCryptos()
            val resultBooksFilter = mutableListOf<Crypto>()
            cryptos.forEach {
                if (it.book.contains("mxn")) {
                    resultBooksFilter.add(it)
                }
            }
            repository.insertBooks(resultBooksFilter.map { it.toDatabase() })
            repository.getAllBooksFromDatabase()
        } else {
            repository.getAllBooksFromDatabase()
        }
    }
}
