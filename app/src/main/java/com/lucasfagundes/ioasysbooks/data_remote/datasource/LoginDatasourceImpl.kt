package com.lucasfagundes.ioasysbooks.data_remote.datasource

import com.lucasfagundes.ioasysbooks.data.datasource.LoginDatasource
import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDatasourceImpl: LoginDatasource {

    override fun login(mail: String, password: String): Flow<User> = flow {
        delay(2000)
        emit(User(
            name = "Lucas",
            birthday = "02/10/1995",
            gender = "male",
            accessToken = "102030"
        ))
    }
}