package com.lucasfagundes.ioasysbooks.common.di

import com.lucasfagundes.ioasysbooks.BuildConfig
import com.lucasfagundes.ioasysbooks.common.network.WebServiceFactory
import org.koin.dsl.module

val commonModule = module {
    single {
        WebServiceFactory.providerOkhttpClient(
            BuildConfig.DEBUG && BuildConfig.BUILD_TYPE == "debug"
        )
    }
}