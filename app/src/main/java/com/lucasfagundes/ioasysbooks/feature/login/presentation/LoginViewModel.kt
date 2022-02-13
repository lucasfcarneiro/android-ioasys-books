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
        viewModelScope.launch {
            _loggerUserViewState.postLoading()

            try {
                loginUseCase(
                    params = LoginUseCase.Params(
                        email = email,
                        password = password
                    )
                ).collect {
                    if (it.name.isNotEmpty()) {
                        _loggerUserViewState.postSuccess(it.accessToken)
                    } else {
                        _loggerUserViewState.postError(Exception("Algo deu errado"))
                    }
                }
            } catch (error: Exception) {
                _loggerUserViewState.postError(error)
            }
        }
    }

    fun resetViewState() {
        _loggerUserViewState.postNeutral()
    }
}
