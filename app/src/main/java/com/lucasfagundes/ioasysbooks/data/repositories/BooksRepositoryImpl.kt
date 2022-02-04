package com.lucasfagundes.ioasysbooks.data.repositories

import com.lucasfagundes.ioasysbooks.data.datasource.BooksDataSource
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(private val booksDataSource: BooksDataSource) : BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksDataSource.getBooks(accessToken, query)
}