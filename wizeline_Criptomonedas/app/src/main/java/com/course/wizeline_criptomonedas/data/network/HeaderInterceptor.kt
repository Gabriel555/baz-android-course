package com.course.wizeline_criptomonedas.data.network

import com.course.wizeline_criptomonedas.data.utils.endpoints.USER_AGENT
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "User-Agent",
                USER_AGENT
            )
            .build()
        return chain.proceed(request)
    }
}
