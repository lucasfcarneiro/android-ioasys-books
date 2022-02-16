package com.lucasfagundes.ioasysbooks.domain.use_case

import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import com.lucasfagundes.ioasysbooks.domain.use_case.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetBooksUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<GetBooksUseCase.Params, List<Book>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Book>> = booksRepository.getBooks(
        bookTitle = params?.bookTitle
    )

    data class Params(
        val bookTitle: String? = null
    )
}