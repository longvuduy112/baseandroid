package com.longvuduy.baseandroid.base.module

import com.longvuduy.baseandroid.HomeFragmentViewModel
import com.longvuduy.baseandroid.MainActivityViewModel
import com.longvuduy.baseandroid.feat.weather.WeatherFragmentViewModel
import com.longvuduy.baseandroid.remote.WeatherRepository
import com.longvuduy.baseandroid.remote.WeatherRepositoryImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<WeatherRepository> { WeatherRepositoryImp() }
    viewModel { MainActivityViewModel() }
    viewModel { HomeFragmentViewModel() }
    viewModel { WeatherFragmentViewModel(get()) }


}
