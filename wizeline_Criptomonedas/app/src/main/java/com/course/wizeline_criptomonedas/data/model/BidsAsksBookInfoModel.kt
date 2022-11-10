package com.course.wizeline_criptomonedas.data.model

data class BidsAsksBookInfoModel(

    val updated_at:String,
    val sequence: String,
    val bids: List<BidsAsksModel>,
    val asks: List<BidsAsksModel>
    )


