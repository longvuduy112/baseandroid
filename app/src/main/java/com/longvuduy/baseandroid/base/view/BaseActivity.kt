package com.longvuduy.baseandroid.base.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : ViewModel, B : ViewBinding> : AppCompatActivity(), IScreen {

    lateinit var binding: B
    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        initData()
        initView()
        initEvent()
        initObserver()
    }

    override fun initData() {
    }

    override fun initEvent() {
    }

    override fun initObserver() {
    }

    override fun initView() {
    }

    abstract fun getViewBinding(): B

    protected fun showToast(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}