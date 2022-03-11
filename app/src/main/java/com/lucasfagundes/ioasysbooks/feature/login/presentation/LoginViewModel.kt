package com.lucasfagundes.ioasysbooks.feature.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasfagundes.ioasysbooks.common.extensions.postError
import com.lucasfagundes.ioasysbooks.common.extensions.postLoading
import com.lucasfagundes.ioasysbooks.common.extensions.postNeutral
import com.lucasfagundes.ioasysbooks.common.extensions.postSuccess
import com.lucasfagundes.ioasysbooks.common.utils.ViewState
import com.lucasfagundes.ioasysbooks.feature.login.domain.use_case.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val loginViewState = MutableLiveData<ViewState<Unit>>()
    val loginLiveData = loginViewState as LiveData<ViewState<Unit>>

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginViewState.postLoading()

            loginUseCase(email, password)
                .flowOn(Dispatchers.IO)
                .catch {
                    loginViewState.postError(it)
                }
                .collect {
                    loginViewState.postSuccess(Unit)
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
        loginViewState.postNeutral()
    }
}