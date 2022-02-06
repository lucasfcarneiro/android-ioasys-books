package com.lucasfagundes.ioasysbooks.data.datasource.local

import kotlinx.coroutines.flow.Flow

interface BookLocalDataSource {

    fun getAccessToken(): Flow<String>
}