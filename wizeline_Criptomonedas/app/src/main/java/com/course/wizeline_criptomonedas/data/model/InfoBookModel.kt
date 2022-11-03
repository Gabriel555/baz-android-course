package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class InfoBookModel(
    @SerializedName("success") val exitoso:String,
    @SerializedName("payload") val infoBook:InfoModel
    )
