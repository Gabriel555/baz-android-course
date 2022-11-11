package com.course.wizeline_criptomonedas.domain.model

import com.course.wizeline_criptomonedas.data.database.entities.CryptoEntity
import com.course.wizeline_criptomonedas.data.model.CryptoModel

data class Crypto(

    val book: String,
    val minimum_price: String,
    val maximum_price: String,
    val minimum_value: String,
    val maximum_value: String,
    var image: Int
)

fun CryptoModel.toDomain() = Crypto(
    book,
    minimum_price,
    maximum_price,
    minimum_value,
    maximum_value,
    image
)
fun CryptoEntity.toDomain() = Crypto(
    book,
    minimum_price,
    maximum_price,
    minimum_value,
    maximum_value,
    image
)