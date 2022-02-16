package com.lucasfagundes.ioasysbooks.data_local.dataSource

import com.lucasfagundes.ioasysbooks.data.datasource.local.BookLocalDataSource
import com.lucasfagundes.ioasysbooks.data_local.SharedPreferenceHelper
import com.lucasfagundes.ioasysbooks.data_local.database.BookDao
import com.lucasfagundes.ioasysbooks.data_local.mappers.toDao
import com.lucasfagundes.ioasysbooks.data_local.mappers.toDomain
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.utils.LocalConstants.ACCESS_TOKEN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookLocalDataSourceImpl(
    private val sharedPreferenceHelper: SharedPreferenceHelper,
    private val bookDao: BookDao
) : BookLocalDataSource {

    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferenceHelper.getString(ACCESS_TOKEN_KEY))
    }

    override fun saveBooks(bookList: List<Book>) = bookDao.addBooks(
        bookList = bookList.map { it.toDao() }
    )

    override fun getBooks(bookTitle: String?): Flow<List<Book>> = flow {
        val bookList = bookDao.getBooks().map { it.toDomain() }
        bookTitle?.let {
            emit(bookList.filter { book ->
                book.title.trim().contains(it, true) ?: false
            })
        } ?: run {
            emit(bookList)
        }
    }
}