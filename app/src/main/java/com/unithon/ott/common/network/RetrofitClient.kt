package com.unithon.ott.common.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val TIMEOUT_COUNT: Long = 10
    private const val BASE_URL =""

    fun getClient(): Retrofit {
        val baseInterceptor = Interceptor { chain ->
            val builder = chain.request().newBuilder()
                .build()
            chain.proceed(builder)
        }

        val client = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_COUNT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_COUNT, TimeUnit.SECONDS)
            .addInterceptor(baseInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}