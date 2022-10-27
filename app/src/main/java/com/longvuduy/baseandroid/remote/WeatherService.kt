package com.longvuduy.baseandroid.remote

import com.longvuduy.baseandroid.model.CurrentWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/forecast")
    suspend fun getWeather(
        @Query("q") q : String = "Ha Noi,+84",
        @Query("appid") apiid : String = "8d5f099e76717231961ab00b0d724395",
        @Query("units") units :String = "metric"
        ) : CurrentWeatherResponse
}