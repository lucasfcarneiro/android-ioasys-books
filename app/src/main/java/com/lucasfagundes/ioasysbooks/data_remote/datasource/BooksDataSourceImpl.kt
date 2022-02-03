package com.lucasfagundes.ioasysbooks.data_remote.datasource

import com.lucasfagundes.ioasysbooks.data.datasource.BooksDataSource
import com.lucasfagundes.ioasysbooks.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDataSourceImpl : BooksDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow{
        val books:List<Book> = listOf(
            Book(
                id = 1,
                title = "asdasdasd"
            ),
            Book(
                id = 2,
                title = "ertertert"
            ),
            Book(
                id = 3,
                title = "uiouiouio"
            ),
            Book(
                id = 4,
                title = "jkljkljkl"
            ),
            Book(
                id = 5,
                title = "qweqweqwe"
            )
        )

        query?.let {
            emit(books.filter { book ->
                book.title.trim().contains(query,true)
            })
        }?: run{
            emit(books)
        }
    }
}