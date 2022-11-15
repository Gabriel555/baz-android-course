package com.course.wizeline_criptomonedas.data.hilt

import com.course.wizeline_criptomonedas.data.network.BookApiClient
import com.course.wizeline_criptomonedas.data.network.HeaderInterceptor
import com.course.wizeline_criptomonedas.data.utils.endpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(endpoints.END_BITSO)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

    @Singleton
    @Provides
    fun provideBookApiClient(retrofit: Retrofit): BookApiClient{
        return retrofit.create(BookApiClient::class.java)
    }
}