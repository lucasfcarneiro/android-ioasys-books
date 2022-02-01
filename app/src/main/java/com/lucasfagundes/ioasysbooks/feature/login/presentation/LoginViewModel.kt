package com.lucasfagundes.ioasysbooks.feature.login.presentation

import androidx.lifecycle.*
import com.lucasfagundes.ioasysbooks.feature.login.exception.LoginException
import com.lucasfagundes.ioasysbooks.utils.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loggerUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggerUserViewState = _loggerUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggerUserViewState.postLoading()

            delay(2000)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                _loggerUserViewState.postSuccess(true)
            } else {
                _loggerUserViewState.postError(LoginException())
            }
        }
    }

    fun ResetViewState()
    {
        _loggerUserViewState.postNeutral()
    }

}