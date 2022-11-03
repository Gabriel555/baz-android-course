package com.course.wizeline_criptomonedas.data.model

import com.google.gson.annotations.SerializedName

data class BidsAsksBookInfoModel(

    @SerializedName("updated_at") val updated_at:String,
    @SerializedName("sequence") val sequence: String,
    @SerializedName("bids") val bids: List<BidsModel>,
    @SerializedName("asks") val asks: List<AsksModel>

    )


