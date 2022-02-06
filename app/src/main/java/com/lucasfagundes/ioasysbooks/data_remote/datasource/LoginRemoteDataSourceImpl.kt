package com.lucasfagundes.ioasysbooks.data_remote.datasource

import com.lucasfagundes.ioasysbooks.data.datasource.remote.LoginRemoteDataSource
import com.lucasfagundes.ioasysbooks.data_remote.mappers.toDomain
import com.lucasfagundes.ioasysbooks.data_remote.model.LoginRequest
import com.lucasfagundes.ioasysbooks.data_remote.service.AuthService
import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSourceImpl(private val authService: AuthService) : LoginRemoteDataSource {

    override fun login(email: String, password: String): Flow<User> = flow {

        val response = authService.signIn(LoginRequest(email, password))
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