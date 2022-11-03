package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(
    @SerializedName("book")
    val book:String,

    @SerializedName("minimum_price")
    val precioMinimo: String,

    @SerializedName("maximum_price")
    val precioMaximo: String,

    @SerializedName("minimum_value")
    val valorMinimo: String,

    @SerializedName("maximum_value")
    val valorMaximo: String,

    var imagen: Int

)
