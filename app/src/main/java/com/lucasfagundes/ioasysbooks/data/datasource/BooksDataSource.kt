package com.lucasfagundes.ioasysbooks.data.datasource

import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDataSource {

    fun getBooks(accessToken:String, query:String?): Flow<List<Book>>
}