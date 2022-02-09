package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.data.datasource.local.BookLocalDataSource
import com.lucasfagundes.ioasysbooks.data.datasource.local.LoginLocalDataSource
import com.lucasfagundes.ioasysbooks.data_local.SharedPreferenceHelper
import com.lucasfagundes.ioasysbooks.data_local.dataSource.BookLocalDataSourceImpl
import com.lucasfagundes.ioasysbooks.data_local.dataSource.LoginLocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single { SharedPreferenceHelper(androidContext()) }

    single <LoginLocalDataSource> { LoginLocalDataSourceImpl(get())}

    single <BookLocalDataSource> { BookLocalDataSourceImpl(get(), get())}
}