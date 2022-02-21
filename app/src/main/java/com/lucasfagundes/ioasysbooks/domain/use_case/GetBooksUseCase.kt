package com.lucasfagundes.ioasysbooks.domain.use_case

import com.lucasfagundes.ioasysbooks.domain.exception.EmptyBookListException
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import com.lucasfagundes.ioasysbooks.domain.use_case.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception

class GetBooksUseCase(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<GetBooksUseCase.Params, List<Book>>(scope = scope) {

    override fun run(params: Params?): Flow<List<Book>> = when (params) {
        null -> throw Exception()
        else -> booksRepository.getBooks(
            bookTitle = params.bookTitle,
            page = params.page
        ).map {
            it.ifEmpty {
                throw EmptyBookListException()
            }
        }
    }

    data class Params(
        val bookTitle: String? = null,
        val page: Int
    )
}