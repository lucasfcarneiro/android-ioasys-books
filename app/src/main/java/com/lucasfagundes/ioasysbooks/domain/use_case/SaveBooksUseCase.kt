package com.lucasfagundes.ioasysbooks.domain.use_case

import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository

class SaveBooksUseCase(private val booksRepository: BooksRepository) {

    operator fun invoke(params:Params) = booksRepository.saveBooks(
        bookList = params.bookList
    )

    data class Params (
        val bookList : List<Book>
    )
}