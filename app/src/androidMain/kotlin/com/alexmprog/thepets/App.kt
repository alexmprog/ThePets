package com.alexmprog.thepets

import android.app.Application
import com.alexmprog.common.logger.Logger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
        initApp()
    }
}

fun initApp() {
    Logger.init()
}
