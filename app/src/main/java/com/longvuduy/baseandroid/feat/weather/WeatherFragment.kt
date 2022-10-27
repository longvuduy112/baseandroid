package com.longvuduy.baseandroid.feat.weather

import android.view.View
import com.longvuduy.baseandroid.base.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.longvuduy.baseandroid.base.view.BaseFragment
import com.longvuduy.baseandroid.databinding.FragmentWeatherBinding


class WeatherFragment : BaseFragment<FragmentWeatherBinding, WeatherFragmentViewModel>() {
    override val viewModel: WeatherFragmentViewModel by viewModel()
    override fun getViewBinding(): FragmentWeatherBinding {
        return FragmentWeatherBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        viewModel.getCurrentWeather()
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.weatherResponse.observe(viewLifecycleOwner) {
            it?.peekContent()?.status?.let { status ->
                when(status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        it.getContentIfNotHandled()?.data?.let { response ->
                            response.list?.let { listItemResponse ->
                                if(listItemResponse.size > 0) {
                                    binding.tvWeather.text =
                                        "${listItemResponse[0].main?.temp.toString()} degree"
                                }
                            }
                        }
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                    }
                }

            }
        }
    }
}