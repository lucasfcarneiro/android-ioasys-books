package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.data.datasource.BooksDataSource
import com.lucasfagundes.ioasysbooks.data.datasource.LoginDatasource
import com.lucasfagundes.ioasysbooks.data_remote.datasource.BooksDataSourceImpl
import com.lucasfagundes.ioasysbooks.data_remote.datasource.LoginDatasourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single<BooksDataSource> {
        BooksDataSourceImpl()
    }

    single<LoginDatasource> {
        LoginDatasourceImpl()
    }
}