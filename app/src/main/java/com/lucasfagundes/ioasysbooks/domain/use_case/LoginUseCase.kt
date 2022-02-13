package com.lucasfagundes.ioasysbooks.domain.use_case

import com.lucasfagundes.ioasysbooks.domain.exception.InvalidEmailException
import com.lucasfagundes.ioasysbooks.domain.exception.InvalidPasswordException
import com.lucasfagundes.ioasysbooks.domain.model.User
import com.lucasfagundes.ioasysbooks.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow


class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    operator fun invoke(params:Params): Flow<User> = when{
        params.email.isEmpty() -> throw InvalidEmailException()
        params.password.isEmpty() -> throw InvalidPasswordException()
        else -> {
            loginRepository.login(
                email = params.email,
                password = params.password
            )
        }
    }

    data class Params(
        val email :String,
        val password:String
    )
}