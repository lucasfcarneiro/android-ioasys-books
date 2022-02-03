package com.lucasfagundes.ioasysbooks.data.datasource

import com.lucasfagundes.ioasysbooks.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginDatasource {

    fun login (mail:String, password:String):Flow<User>
}