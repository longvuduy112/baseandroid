package com.longvuduy.baseandroid.base.listener

interface BaseFirebaseListener<T> {
    fun onLoading(isLoading: Boolean)
    fun onSuccess(data: T)
    fun onFailed(errorMessage: String)
}