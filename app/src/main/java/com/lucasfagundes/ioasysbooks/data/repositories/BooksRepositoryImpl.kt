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

    override fun getBooks(bookTitle: String?, page: Int): Flow<List<Book>> = flow {
        bookLocalDataSource.getAccessToken().collect { token ->
            if (token.isNotEmpty()) {
                booksRemoteDataSource.getBooks(token, bookTitle, page).collect { bookList ->
                    emit(bookList)
                }
            } else {
                bookLocalDataSource.getBooks(bookTitle).collect { bookList ->
                    emit(bookList)
                }
            }
        }
    }

    override fun saveBooks(bookList: List<Book>) = bookLocalDataSource.saveBooks(
        bookList = bookList
    )
}