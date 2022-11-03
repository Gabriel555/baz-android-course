package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class AsksModel(
    @SerializedName("book") val book:String,
    @SerializedName("price") val price: String,
    @SerializedName("amount") val amount: String
)
