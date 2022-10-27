package com.longvuduy.baseandroid

import android.os.Bundle
import com.longvuduy.baseandroid.base.view.BaseActivity
import com.longvuduy.baseandroid.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    override val viewModel: MainActivityViewModel by viewModel()
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}