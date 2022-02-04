package com.lucasfagundes.ioasysbooks.feature.login.presentation

import androidx.lifecycle.*
import com.lucasfagundes.ioasysbooks.domain.repositories.LoginRepository
import com.lucasfagundes.ioasysbooks.utils.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loggerUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggerUserViewState = _loggerUserViewState as LiveData<ViewState<Boolean>>

    fun login(mail: String, password: String) {
        viewModelScope.launch {
            _loggerUserViewState.postLoading()

            try {
                loginRepository.login(mail, password).collect {
                    if (it.name.isNotEmpty()) {
                        _loggerUserViewState.postSuccess(true)
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
