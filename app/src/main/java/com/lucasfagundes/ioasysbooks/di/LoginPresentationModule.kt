package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginPresentationModule = module {
    viewModel{
        LoginViewModel(get ())
    }
}