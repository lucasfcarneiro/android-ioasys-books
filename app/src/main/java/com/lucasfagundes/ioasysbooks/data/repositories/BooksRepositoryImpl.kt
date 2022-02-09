package com.lucasfagundes.ioasysbooks.data.repositories

import com.lucasfagundes.ioasysbooks.data.datasource.local.BookLocalDataSource
import com.lucasfagundes.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val bookLocalDataSource: BookLocalDataSource
) : BooksRepository {

    override fun getBooks( query: String?): Flow<List<Book>> = flow {
        bookLocalDataSource.getAccessToken().collect { token ->
            booksRemoteDataSource.getBooks(token, query).collect { bookList ->
                emit(bookList)
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = bookLocalDataSource.saveBooks(
        bookList = bookList
    )
}