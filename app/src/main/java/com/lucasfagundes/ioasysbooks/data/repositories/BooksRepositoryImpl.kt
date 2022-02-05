package com.lucasfagundes.ioasysbooks.data.repositories

import com.lucasfagundes.ioasysbooks.data.datasource.remote.BooksRemoteDataSource
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(private val booksRemoteDataSource: BooksRemoteDataSource) : BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksRemoteDataSource.getBooks(accessToken, query)
}