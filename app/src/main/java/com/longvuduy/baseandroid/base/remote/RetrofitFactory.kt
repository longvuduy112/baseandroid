package com.longvuduy.baseandroid.base.remote

object RetrofitFactory {
    fun getServer(server: Server): IServer {
        return when (server) {
            Server.Weather -> {
                WeatherServer()
            }
        }
    }
}