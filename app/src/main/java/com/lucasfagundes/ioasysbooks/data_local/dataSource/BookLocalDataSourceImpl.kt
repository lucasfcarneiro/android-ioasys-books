package com.lucasfagundes.ioasysbooks.data_local.dataSource

import com.lucasfagundes.ioasysbooks.data.datasource.local.BookLocalDataSource
import com.lucasfagundes.ioasysbooks.data_local.SharedPreferenceHelper
import com.lucasfagundes.ioasysbooks.utils.LocalConstants.ACCESS_TOKEN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookLocalDataSourceImpl(private val sharedPreferenceHelper: SharedPreferenceHelper): BookLocalDataSource{

    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferenceHelper.getString(ACCESS_TOKEN_KEY))
    }
}