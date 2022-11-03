package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class BidsAsksBookModel(
    @SerializedName("success") val exitoso:String,
    @SerializedName("payload") val infoBidsAsks:BidsAsksBookInfoModel
    )
