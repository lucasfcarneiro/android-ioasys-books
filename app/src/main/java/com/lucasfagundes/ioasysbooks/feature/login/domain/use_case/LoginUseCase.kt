package com.lucasfagundes.ioasysbooks.feature.login.domain.use_case

import com.lucasfagundes.ioasysbooks.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val repository:LoginRepository) {

    operator fun invoke(email:String,password:String): Flow<Unit> =
        repository.login(email, password)
}