package com.longvuduy.baseandroid.base.utils

import android.app.Activity
import android.app.Service
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


object KeyboardUtils {
    fun showKeyboard(context: Context) {
        val inputMethodManager: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun closeKeyboard(context: Context) {
        val inputMethodManager: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }
    fun hideKeyboardFrom(context: Context?, view: View) {
        val imm: InputMethodManager? =
            context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun showKeyboard(
        edt: EditText?,
        activity: Activity
    ) {
        if (edt != null) {
            edt.requestFocus()
            edt.postDelayed(Runnable {
                val imm =
                    activity.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(
                    edt,
                    InputMethodManager.SHOW_IMPLICIT
                )
            }, 200)
        }
    }
}