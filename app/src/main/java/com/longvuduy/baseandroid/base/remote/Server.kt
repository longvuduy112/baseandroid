package com.longvuduy.baseandroid.base.remote


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



enum class Server {
    Weather

}

interface IServer {
    fun getRetrofit(): Retrofit
}

class WeatherServer : IServer {
    override fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl.weatherUrl)
            .client(OkHttpClientConfig.getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}




