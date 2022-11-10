package com.course.wizeline_criptomonedas.core

import com.course.wizeline_criptomonedas.data.utils.endpoints.END_BITSO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(END_BITSO)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}