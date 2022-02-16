package com.lucasfagundes.ioasysbooks.domain.repositories

import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(bookTitle:String?): Flow<List<Book>>

    fun saveBooks(bookList:List<Book>)
}