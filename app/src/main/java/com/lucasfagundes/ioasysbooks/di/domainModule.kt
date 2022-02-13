package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.domain.use_case.GetBookListUseCase
import com.lucasfagundes.ioasysbooks.domain.use_case.LoginUseCase
import com.lucasfagundes.ioasysbooks.domain.use_case.SaveBooksUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {

    single { CoroutineScope(Dispatchers.IO) }

    factory { LoginUseCase(get(),get()) }
    factory { SaveBooksUseCase(get(),get()) }
    factory { GetBookListUseCase(get(),get()) }
}