package com.longvuduy.baseandroid.base.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


object OkHttpClientConfig {
    fun getOkHttpClient(): OkHttpClient {
        val time = 30L
        val interceptor: Interceptor
        interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder()
            .connectTimeout(time, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .readTimeout(time, TimeUnit.SECONDS)
            .writeTimeout(time, TimeUnit.SECONDS)
            .build()
    }
}