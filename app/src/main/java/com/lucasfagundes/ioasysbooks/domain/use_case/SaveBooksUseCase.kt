package com.lucasfagundes.ioasysbooks.domain.use_case

import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import com.lucasfagundes.ioasysbooks.domain.use_case.utils.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveBooksUseCase(
    private val booksRepository: BooksRepository,
    scope:CoroutineScope
    ):UseCase<SaveBooksUseCase.Params, Unit>(scope = scope) {

    override fun run(params: Params?): Flow<Unit> = flowOf(
        booksRepository.saveBooks(
            bookList = params?.bookList ?: listOf()
        )
    )

    data class Params (
        val bookList : List<Book>
    )


}