package com.course.wizeline_criptomonedas.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BidsAsksBookProvider @Inject constructor(){
        lateinit var bidsAsksBook:BidsAsksBookModel
}