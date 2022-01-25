package com.lucasfagundes.ioasysbooks.base_app

import android.app.Application
import com.lucasfagundes.ioasysbooks.feature.login.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@BaseApplication)
            modules(viewModelModule)
        }
    }
}