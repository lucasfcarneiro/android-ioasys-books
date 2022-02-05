package com.lucasfagundes.ioasysbooks.feature.login.di

import com.lucasfagundes.ioasysbooks.common.network.ApiConstants
import com.lucasfagundes.ioasysbooks.common.network.WebServiceFactory
import com.lucasfagundes.ioasysbooks.feature.login.data.remote.data_source.LoginRemoteDataSource
import com.lucasfagundes.ioasysbooks.feature.login.data.remote.service.LoginService
import com.lucasfagundes.ioasysbooks.feature.login.data.repository.LoginRepositoryImpl
import com.lucasfagundes.ioasysbooks.feature.login.domain.repository.LoginRepository
import com.lucasfagundes.ioasysbooks.feature.login.domain.use_case.LoginUseCase
import com.lucasfagundes.ioasysbooks.feature.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )as LoginService
    }

    factory<LoginRepository> {
        LoginRepositoryImpl(
            remoteDataSource = LoginRemoteDataSource()
        )
    }

    viewModel {
        LoginViewModel(loginUseCase = LoginUseCase(get()))
    }
}