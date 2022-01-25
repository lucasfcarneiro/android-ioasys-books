package com.lucasfagundes.ioasysbooks.feature.login.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import org.koin.core.KoinComponent

class LoginViewModel(application:Application):AndroidViewModel(application),LifecycleObserver,
    KoinComponent {

}