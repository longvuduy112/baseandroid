package com.longvuduy.baseandroid.base.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONException

object HandleError {
    fun handlerHttpConnection(exception : retrofit2.HttpException){
        val errorBody : String = exception.response()?.errorBody()?.string() ?: ""

        try {
            val code = exception.code()
        } catch (e: JSONException) {

        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun ResponseBody.stringSuspending() =
        withContext(Dispatchers.IO) { string() }
}