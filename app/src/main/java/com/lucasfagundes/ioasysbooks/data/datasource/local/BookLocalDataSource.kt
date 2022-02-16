package com.lucasfagundes.ioasysbooks.data.datasource.local

import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookLocalDataSource {

    fun getAccessToken(): Flow<String>
    fun saveBooks(bookList:List<Book>)
    fun getBooks(bookTitle:String?):Flow<List<Book>>

}