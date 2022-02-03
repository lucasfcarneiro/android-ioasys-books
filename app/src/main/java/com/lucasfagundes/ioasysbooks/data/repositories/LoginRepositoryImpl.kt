package com.lucasfagundes.ioasysbooks.data.repositories

import com.lucasfagundes.ioasysbooks.data.datasource.LoginDatasource
import com.lucasfagundes.ioasysbooks.domain.repositories.LoginRepository
import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(private val loginDatasource: LoginDatasource) : LoginRepository {

    override fun login(mail: String, password: String): Flow<User> =
        loginDatasource.login(mail, password)

}