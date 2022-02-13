package com.lucasfagundes.ioasysbooks.feature.login.presentation

import androidx.lifecycle.*
import com.lucasfagundes.ioasysbooks.domain.repositories.LoginRepository
import com.lucasfagundes.ioasysbooks.domain.use_case.LoginUseCase
import com.lucasfagundes.ioasysbooks.utils.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loggerUserViewState = MutableLiveData<ViewState<String>>()
    val loggerUserViewState = _loggerUserViewState as LiveData<ViewState<String>>

    fun login(email: String, password: String) {
        _loggerUserViewState.postLoading()
        loginUseCase(
            params = LoginUseCase.Params(
                email = email,
                password = password
            ),
            onSuccess = {
                _loggerUserViewState.postSuccess(it.accessToken)
            },
            onError = {
                _loggerUserViewState.postError(it)
            }
        )
    }

    fun resetViewState() {
        _loggerUserViewState.postNeutral()
    }
}
