package com.lucasfagundes.ioasysbooks.data.repositories

import com.lucasfagundes.ioasysbooks.data.datasource.local.LoginLocalDataSource
import com.lucasfagundes.ioasysbooks.data.datasource.remote.LoginRemoteDataSource
import com.lucasfagundes.ioasysbooks.domain.repositories.LoginRepository
import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource
) : LoginRepository {

    override fun login(email: String, password: String): Flow<User> = flow {
        loginRemoteDataSource.login(email, password).collect { userData ->
            loginLocalDataSource.savaAccessToken(accessToken = userData.accessToken)

            emit(userData)
        }
    }
}
