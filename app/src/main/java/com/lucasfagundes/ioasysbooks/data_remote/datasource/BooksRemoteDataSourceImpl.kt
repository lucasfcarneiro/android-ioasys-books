package com.lucasfagundes.ioasysbooks.data_remote.datasource

import com.lucasfagundes.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.lucasfagundes.ioasysbooks.data_remote.mappers.todomain
import com.lucasfagundes.ioasysbooks.data_remote.service.BookService
import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDataSourceImpl(private val bookService: BookService) : BooksRemoteDataSource {

    override fun getBooks(accessToken: String, bookTitle: String?): Flow<List<Book>> = flow {

        val response = bookService.getBooks(
                accessToken = "Bearer $accessToken",
                page = 1,
                title = bookTitle
        )

        if (response.isSuccessful) {
            response.body()?.data?.let { bookList ->
                bookTitle?.let {
                    emit(bookList.filter { book ->
                        book.title?.trim()?.contains(it, true) ?: false
                    }.todomain())
                } ?: run {
                    emit(bookList.todomain())
                }
            }
        }
    }
}