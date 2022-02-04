package com.lucasfagundes.ioasysbooks.data_remote.service

import  com.lucasfagundes.ioasysbooks.data_remote.model.LoginRequest
import com.lucasfagundes.ioasysbooks.data_remote.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/sign-in")
    suspend fun signIn(@Body loginRequest: LoginRequest): Response<LoginResponse>

}