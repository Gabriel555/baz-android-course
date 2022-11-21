package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.repositories.BookRepository
import com.course.wizeline_criptomonedas.domain.model.Crypto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetBooksUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: BookRepository

    lateinit var getBooksUseCase: GetBooksUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getBooksUseCase = GetBooksUseCase(repository = repository)
    }

    /*@Test
    fun `cuando el api no devuelve datos entonces se obtienen de la Base de Datos`() = runBlocking {
        // Given
        coEvery { repository.getAllBooksFromApi() } returns emptyList()

        // when
        getBooksUseCase()

        // then
        coVerify(exactly = 1) { repository.getAllBooksFromDatabase() }
    }

    @Test
    fun `cuando el api devuelve algo entonces almacenar en base de Datos los valores del api`() = runBlocking {
        // Given
        val listaMock = listOf(Crypto(book = "btc_mxn", minimum_price = "000000", maximum_price = "1234567890", minimum_value = "0", maximum_value = "987654321", image = 123))
        coEvery { repository.getAllBooksFromApi() } returns listaMock

        // when
        val respuesta = getBooksUseCase()

        // then
        coVerify(exactly = 1) { repository.clearCryptos() }
        coVerify(exactly = 1) { repository.insertBooks(any()) }
        coVerify(exactly = 1) { repository.getAllBooksFromDatabase() }
    }*/
}
