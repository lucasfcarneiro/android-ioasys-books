package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.domain.use_case.GetBookListUseCase
import com.lucasfagundes.ioasysbooks.domain.use_case.LoginUseCase
import com.lucasfagundes.ioasysbooks.domain.use_case.SaveBooksUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
    factory { SaveBooksUseCase(get()) }
    factory { GetBookListUseCase(get()) }
}