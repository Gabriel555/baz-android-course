package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class BookModel(

    val success:String,

    @SerializedName("payload")
    val crypto:List<CryptoModel>
    )
