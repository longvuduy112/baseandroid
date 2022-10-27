package com.longvuduy.baseandroid.feat.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.longvuduy.baseandroid.base.utils.HandleError
import com.longvuduy.baseandroid.base.utils.HandleError.stringSuspending
import com.longvuduy.baseandroid.base.utils.HandleLiveData
import com.longvuduy.baseandroid.base.utils.Resource
import com.longvuduy.baseandroid.base.viewmodel.BaseViewModel
import com.longvuduy.baseandroid.model.CurrentWeatherResponse
import com.longvuduy.baseandroid.remote.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class WeatherFragmentViewModel(private val weatherRepository : WeatherRepository) : BaseViewModel() {
    var weatherResponse = MutableLiveData<HandleLiveData<Resource<CurrentWeatherResponse>>>()
    fun getCurrentWeather() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                weatherResponse.postValue(HandleLiveData(Resource.loading(null)))
                val response = weatherRepository.getWeather()
                weatherResponse.postValue(HandleLiveData(Resource.success(response)))
            }catch (e: Throwable){
                if (e is retrofit2.HttpException) {
                    val errorBody: String = e.response()?.errorBody()?.stringSuspending() ?: ""
                    weatherResponse.postValue(HandleLiveData(Resource.error(errorBody, null)))
                    HandleError.handlerHttpConnection(e)
                }else if (e is SocketTimeoutException){
                    weatherResponse.postValue(HandleLiveData(Resource.error("$e",null)))
                }
            }
        }
    }
}