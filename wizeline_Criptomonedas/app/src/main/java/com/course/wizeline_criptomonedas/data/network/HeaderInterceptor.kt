package com.course.wizeline_criptomonedas.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
            "User-Agent","OkHttp: "
            )
            .build()
        return chain.proceed(request)
    }
}