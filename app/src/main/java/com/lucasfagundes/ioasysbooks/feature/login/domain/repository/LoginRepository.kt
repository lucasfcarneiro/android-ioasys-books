package com.lucasfagundes.ioasysbooks.feature.login.domain.repository

import com.lucasfagundes.ioasysbooks.feature.login.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(email: String, password: String): Flow<User>
}