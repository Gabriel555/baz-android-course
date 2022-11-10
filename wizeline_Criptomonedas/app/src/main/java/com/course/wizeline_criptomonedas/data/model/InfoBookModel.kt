package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class InfoBookModel(

    val success:String,

    @SerializedName("payload")
    val infoBook:InfoModel

    )
