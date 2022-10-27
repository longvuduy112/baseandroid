package com.longvuduy.baseandroid.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("list") var list: ArrayList<ListItemResponse>
)

data class ListItemResponse(
    @SerializedName("dt") var dt : String?,
    @SerializedName("main") var main : Main?
)
data class Main(
    @SerializedName("temp") var temp : Double?
)
data class WeatherItem(
    @SerializedName("id") var id : Long?,
    @SerializedName("main") var main : String?,
    @SerializedName("description") var description : String?,
    @SerializedName("icon") var icon : String?,
)