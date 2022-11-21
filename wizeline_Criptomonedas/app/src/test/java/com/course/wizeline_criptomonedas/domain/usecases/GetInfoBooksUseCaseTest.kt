package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.data.model.InfoBookModel
import com.course.wizeline_criptomonedas.data.model.InfoModel
import com.course.wizeline_criptomonedas.data.repositories.InfoBookRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetInfoBooksUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: InfoBookRepository

    lateinit var getInfoBooksUseCase: GetInfoBooksUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getInfoBooksUseCase = GetInfoBooksUseCase(repository = repository)
    }

    @Test
    fun `cuando el api devuelve datos`() = runBlocking {
        // Given
        val emptyInfo = InfoBookModel(
            "success",
            InfoModel("1234", "0987", "0987", "bitcoin", "09876", "23456")
        )
        coEvery { repository.getInfoBooks("btc_mxn") } returns emptyInfo

        // when
        val response = getInfoBooksUseCase("btc_mxn")

        // then
        assert(response == emptyInfo)
    }

    @Test
    fun `cuando el api nos devuelve un error codigo 404`() = runBlocking {
        // Given
        val emptyInfo = InfoBookModel(
            "",
            InfoModel("", "", "", "", "", "")
        )
        coEvery { repository.getInfoBooks("btc_mxn") } returnsArgument 404

        // when
        val response = getInfoBooksUseCase("btc_mxn")

        // then
        assert(response == emptyInfo)
    }
}
