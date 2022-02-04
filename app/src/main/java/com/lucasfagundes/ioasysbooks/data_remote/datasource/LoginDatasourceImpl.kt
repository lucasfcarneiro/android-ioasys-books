package com.lucasfagundes.ioasysbooks.data_remote.datasource

import com.lucasfagundes.ioasysbooks.data.datasource.LoginDatasource
import com.lucasfagundes.ioasysbooks.data_remote.mappers.toDomain
import com.lucasfagundes.ioasysbooks.data_remote.model.LoginRequest
import com.lucasfagundes.ioasysbooks.data_remote.model.LoginResponse
import com.lucasfagundes.ioasysbooks.data_remote.service.AuthService
import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody

class LoginDatasourceImpl(private val authService: AuthService) : LoginDatasource {

    override fun login(mail: String, password: String): Flow<User> = flow {

        val response = authService.signIn(LoginRequest(mail, password))
        val accessToken = response.headers()["authorization"]

        if (response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken ?: ""))
            }
        }else{
            emit(throw Exception("error"))
        }
    }
}