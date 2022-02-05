package com.lucasfagundes.ioasysbooks.domain.repositories

import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email:String,password:String): Flow<User>

}