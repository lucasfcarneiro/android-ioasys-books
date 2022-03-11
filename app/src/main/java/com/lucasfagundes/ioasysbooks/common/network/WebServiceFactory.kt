package com.lucasfagundes.ioasysbooks.common.network

import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

object WebServiceFactory {

    inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String = ""): T {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }

    fun  providerOkhttpClient(isDebug: Boolean): OkHttpClient =
        OkHttpClient.Builder()
            .dispatcher(Dispatcher().apply {
                maxRequests = 1
                maxRequestsPerHost = 1
            })
            .connectTimeout(30L, TimeUnit.SECONDS)
            .readTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
            .httpLoggingInterceptor(isDebug)
            .build()

    private fun OkHttpClient.Builder.httpLoggingInterceptor(isDebug: Boolean) =
        when (isDebug) {
            true -> {
                val interceptor = HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
                addInterceptor(interceptor)
            }
            else -> this
        }
}


