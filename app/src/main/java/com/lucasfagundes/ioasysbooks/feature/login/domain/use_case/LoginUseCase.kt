package com.lucasfagundes.ioasysbooks.feature.login.domain.use_case

import com.lucasfagundes.ioasysbooks.common.exception.EmptyEmailException
import com.lucasfagundes.ioasysbooks.common.exception.EmptyPasswordException
import com.lucasfagundes.ioasysbooks.feature.login.domain.model.User
import com.lucasfagundes.ioasysbooks.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val repository: LoginRepository) {

    operator fun invoke(email: String, password: String): Flow<User> = when {
        email.isEmpty() -> flow { throw EmptyEmailException() }
        password.isEmpty() -> flow { throw EmptyPasswordException() }
        else -> repository.login(email, password)
    }
}