package com.lucasfagundes.ioasysbooks.feature.login.data.remote.data_source

import com.lucasfagundes.ioasysbooks.common.exception.GenericException
import com.lucasfagundes.ioasysbooks.feature.login.data.remote.model.LoginRequest
import com.lucasfagundes.ioasysbooks.feature.login.data.remote.model.LoginResponse
import com.lucasfagundes.ioasysbooks.feature.login.data.remote.service.LoginService
import com.lucasfagundes.ioasysbooks.feature.login.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSource(private val service: LoginService) {

    fun login(email: String, password: String): Flow<User> = flow {
        val response = service.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]

        if (response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken ?: ""))
            }
        } else {
            throw GenericException()
        }
    }

    private fun LoginResponse.toDomain(accessToken: String) = User(
        name = name.orEmpty(),
        birthday = birthday.orEmpty(),
        gender = gender.orEmpty(),
        accessToken = accessToken,
        id = id.orEmpty()
    )
}