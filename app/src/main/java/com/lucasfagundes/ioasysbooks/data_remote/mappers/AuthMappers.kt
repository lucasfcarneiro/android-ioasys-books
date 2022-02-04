package com.lucasfagundes.ioasysbooks.data_remote.mappers

import com.lucasfagundes.ioasysbooks.data_remote.model.LoginResponse
import com.lucasfagundes.ioasysbooks.domain.model.User

fun LoginResponse.toDomain(accessToken :String) = User(
    name = this.name.orEmpty(),
    birthday = this.birthday.orEmpty(),
    gender = this.gender.orEmpty(),
    accessToken = accessToken,
    id = this.id.orEmpty()
)