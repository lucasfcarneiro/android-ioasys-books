package com.lucasfagundes.ioasysbooks.domain.use_case

import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class GetBookListUseCase(private val booksRepository: BooksRepository) {

    operator fun invoke(params: Params):Flow<List<Book>> = booksRepository.getBooks(
        query = params.input
    )

    data class Params(
        val input: String
    )
}