package com.longvuduy.baseandroid

import androidx.navigation.fragment.findNavController
import com.longvuduy.baseandroid.base.view.BaseFragment
import com.longvuduy.baseandroid.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeFragmentViewModel>() {
    override val viewModel: HomeFragmentViewModel by viewModel()
    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        binding.tvGoWeather.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_weatherFragment)
        }
    }

    override fun initObserver() {
        super.initObserver()
    }
}