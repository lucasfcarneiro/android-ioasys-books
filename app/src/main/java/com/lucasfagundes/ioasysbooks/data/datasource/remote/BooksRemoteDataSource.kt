package com.lucasfagundes.ioasysbooks.data.datasource.remote

import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken:String, query:String?): Flow<List<Book>>
}