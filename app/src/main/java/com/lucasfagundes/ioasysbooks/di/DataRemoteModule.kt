package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.lucasfagundes.ioasysbooks.data.datasource.remote.LoginRemoteDataSource
import com.lucasfagundes.ioasysbooks.data_remote.datasource.BooksRemoteDataSourceImpl
import com.lucasfagundes.ioasysbooks.data_remote.datasource.LoginRemoteDataSourceImpl
import com.lucasfagundes.ioasysbooks.data_remote.service.AuthService
import com.lucasfagundes.ioasysbooks.data_remote.service.BookService
import com.lucasfagundes.ioasysbooks.data_remote.utils.ApiConstants
import com.lucasfagundes.ioasysbooks.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createdWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<BookService> {
        WebServiceFactory.createdWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkhttpClient() }

    single<BooksRemoteDataSource> {
        BooksRemoteDataSourceImpl(get())
    }

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }
}