package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.data.repositories.BooksRepositoryImpl
import com.lucasfagundes.ioasysbooks.data.repositories.LoginRepositoryImpl
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import com.lucasfagundes.ioasysbooks.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }

    single<BooksRepository>{
        BooksRepositoryImpl(get())
    }
}