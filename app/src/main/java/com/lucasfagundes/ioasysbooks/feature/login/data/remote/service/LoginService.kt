package com.lucasfagundes.ioasysbooks.feature.login.data.remote.service

import com.lucasfagundes.ioasysbooks.feature.login.data.remote.model.LoginRequest
import com.lucasfagundes.ioasysbooks.feature.login.data.remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("auth/sign-in")
    suspend fun signIn(@Body loginRequest: LoginRequest): Response<LoginResponse>

}