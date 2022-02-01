package com.lucasfagundes.ioasysbooks.feature.login.di

import com.lucasfagundes.ioasysbooks.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{
        LoginViewModel()
    }
}