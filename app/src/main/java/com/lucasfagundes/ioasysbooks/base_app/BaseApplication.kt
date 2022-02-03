package com.lucasfagundes.ioasysbooks.base_app

import android.app.Application
import com.lucasfagundes.ioasysbooks.di.dataModule
import com.lucasfagundes.ioasysbooks.di.dataRemoteModule
import com.lucasfagundes.ioasysbooks.di.bookPresentationModule
import com.lucasfagundes.ioasysbooks.di.loginPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    bookPresentationModule,
                    loginPresentationModule,
                    dataModule,
                    dataRemoteModule)
            ).androidContext(applicationContext)
        }
    }
}