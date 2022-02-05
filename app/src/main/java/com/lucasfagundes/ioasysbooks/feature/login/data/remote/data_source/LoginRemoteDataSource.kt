package com.lucasfagundes.ioasysbooks.feature.login.data.remote.data_source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSource {
    fun login(email:String,password:String): Flow<Unit> = flow {
        emit(Unit)
    }
}