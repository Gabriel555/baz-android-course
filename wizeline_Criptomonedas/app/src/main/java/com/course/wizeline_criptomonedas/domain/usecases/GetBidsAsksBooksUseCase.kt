package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.model.BidsAsksBookModel
import com.course.wizeline_criptomonedas.data.repositories.BidsAsksBookRepository
import javax.inject.Inject

class GetBidsAsksBooksUseCase @Inject constructor(
    private val repository: BidsAsksBookRepository
) {
    suspend operator fun invoke(book: String): BidsAsksBookModel = repository.getBidsAsksBooks(book = book)
}
