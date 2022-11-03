package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class BookModel(
    @SerializedName("success")
    val exitoso:String,

    @SerializedName("payload")
    val crypto:List<CryptoModel>
    )
