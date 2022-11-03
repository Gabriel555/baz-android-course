package com.course.wizeline_criptomonedas.domain.usecases

import com.course.wizeline_criptomonedas.R
import com.course.wizeline_criptomonedas.data.model.CryptoModel
import com.course.wizeline_criptomonedas.data.repositories.BookRepository

class GetBooksUseCase {

    private val repository = BookRepository()

    suspend operator fun invoke(): List<CryptoModel> {
        val resultBooksFilter = mutableListOf<CryptoModel>()
        val mapaImagenes = mapOf(
            "btc_mxn" to R.drawable.ic_coin_btc,
            "eth_mxn" to R.drawable.ic_coin_bat,
            "xrp_mxn" to R.drawable.ic_coin_bat,
            "ltc_mxn" to R.drawable.ic_coin_bat,
            "bch_mxn" to R.drawable.ic_coin_bat,
            "tusd_mxn" to R.drawable.ic_coin_bat,
            "mana_mxn" to R.drawable.ic_coin_bat,
            "bat_mxn" to R.drawable.ic_coin_bat,
            "dai_mxn" to R.drawable.ic_coin_bat,
            "usd_mxn" to R.drawable.ic_coin_bat
        )
        if (!repository.getAllBooks().isNullOrEmpty()){
            repository.getAllBooks().forEach {
                if (it.book.contains("mxn")){
                    it.imagen = mapaImagenes[it.book]!!
                    resultBooksFilter.add(it)
                }
            }
        }
        return resultBooksFilter
    }
}