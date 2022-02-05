package com.lucasfagundes.ioasysbooks.base_app

import android.app.Application
import com.lucasfagundes.ioasysbooks.feature.login.di.loginModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(loginModule)
            ).androidContext(applicationContext)
        }
    }
}