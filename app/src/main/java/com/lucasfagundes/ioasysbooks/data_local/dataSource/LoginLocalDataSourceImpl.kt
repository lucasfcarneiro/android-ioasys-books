package com.lucasfagundes.ioasysbooks.data_local.dataSource

import com.lucasfagundes.ioasysbooks.data.datasource.local.LoginLocalDataSource
import com.lucasfagundes.ioasysbooks.data_local.SharedPreferenceHelper
import com.lucasfagundes.ioasysbooks.utils.LocalConstants.ACCESS_TOKEN_KEY

class LoginLocalDataSourceImpl(private val sharedPreferenceHelper: SharedPreferenceHelper) :
    LoginLocalDataSource {

    override fun savaAccessToken(accessToken: String) = sharedPreferenceHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = accessToken
    )
}
