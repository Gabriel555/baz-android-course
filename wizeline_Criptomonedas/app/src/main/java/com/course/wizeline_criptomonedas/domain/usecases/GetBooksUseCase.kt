package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.database.entities.toDatabase
import com.course.wizeline_criptomonedas.data.repositories.BookRepository
import com.course.wizeline_criptomonedas.domain.model.Crypto
import com.course.wizeline_criptomonedas.domain.model.toDomain
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend operator fun invoke(): List<Crypto> {
        repository.getAllBooksFromApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ cryptos ->
                //repository.clearCryptos()
                val resultBooksFilter = mutableListOf<Crypto>()
                cryptos.forEach {
                    if (it.book.contains("mxn")) {
                        resultBooksFilter.add(it.toDomain())
                    }
                }
                //repository.insertBooks(resultBooksFilter.map { it.toDatabase() })
            }, {
            })
        return repository.getAllBooksFromDatabase()
    }
}
