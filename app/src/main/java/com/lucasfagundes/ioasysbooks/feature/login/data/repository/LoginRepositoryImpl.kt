package com.lucasfagundes.ioasysbooks.feature.login.data.repository

import com.lucasfagundes.ioasysbooks.feature.login.data.remote.data_source.LoginRemoteDataSource
import com.lucasfagundes.ioasysbooks.feature.login.domain.model.User
import com.lucasfagundes.ioasysbooks.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(private val remoteDataSource: LoginRemoteDataSource) : LoginRepository {
    override fun login(email: String, password: String): Flow<User> =
        remoteDataSource.login(email,password)
}