package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class InfoModel (
    @SerializedName("high") val high:String,
    @SerializedName("last") val last: String,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("book") val book: String,
    @SerializedName("volume") val volume: String
)
