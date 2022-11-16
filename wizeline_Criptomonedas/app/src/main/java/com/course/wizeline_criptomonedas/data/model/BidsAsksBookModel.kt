package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class BidsAsksBookModel(

    val success: String,

    @SerializedName("payload")
    val infoBidsAsks: BidsAsksBookInfoModel

)
