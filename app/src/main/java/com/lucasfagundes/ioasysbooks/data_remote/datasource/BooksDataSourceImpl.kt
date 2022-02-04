package com.lucasfagundes.ioasysbooks.data_remote.datasource

import com.lucasfagundes.ioasysbooks.data.datasource.BooksDataSource
import com.lucasfagundes.ioasysbooks.data_remote.mappers.todomain
import com.lucasfagundes.ioasysbooks.data_remote.service.BookService
import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDataSourceImpl(private val bookService: BookService) : BooksDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {

        val response = bookService.getBooks(accessToken = "Bearer $accessToken", page = 1)

        if (response.isSuccessful) {
            response.body()?.data?.let { bookList ->
                query?.let {
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