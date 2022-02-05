package com.lucasfagundes.ioasysbooks.data.datasource.remote

import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRemoteDataSource {

    fun login (email:String, password:String):Flow<User>
}