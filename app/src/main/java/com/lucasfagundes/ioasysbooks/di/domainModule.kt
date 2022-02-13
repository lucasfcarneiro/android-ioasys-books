package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.domain.use_case.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LoginUseCase(get()) }
}