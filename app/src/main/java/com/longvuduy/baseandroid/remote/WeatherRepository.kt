package com.longvuduy.baseandroid.remote


import com.longvuduy.baseandroid.base.remote.RetrofitFactory
import com.longvuduy.baseandroid.base.remote.Server
import com.longvuduy.baseandroid.model.CurrentWeatherResponse
import retrofit2.Retrofit

interface WeatherRepository {
    suspend fun getWeather(): CurrentWeatherResponse
}

class WeatherRepositoryImp : WeatherRepository {
    private val weatherService by lazy {
        getRetrofit().create(WeatherService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return RetrofitFactory.getServer(Server.Weather).getRetrofit()
    }

    override suspend fun getWeather(): CurrentWeatherResponse = weatherService.getWeather()
}