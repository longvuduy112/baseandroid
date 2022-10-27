package com.longvuduy.baseandroid

import android.app.Application
import com.longvuduy.baseandroid.base.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(appModule)
        }
    }
}
