package com.lucasfagundes.ioasysbooks.feature.book.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.use_case.GetBooksUseCase
import com.lucasfagundes.ioasysbooks.domain.use_case.SaveBooksUseCase
import com.lucasfagundes.ioasysbooks.utils.*

class BookListViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val saveBooksUseCase: SaveBooksUseCase
) : ViewModel() {

    private val bookListViewState = MutableLiveData<ViewState<Pair<List<Book>, Boolean>>>()
    val bookListLiveData = bookListViewState as LiveData<ViewState<Pair<List<Book>, Boolean>>>
    private var page: Int = 1

    init {
        getBooks()
    }

    fun getBooks(bookTitle: String? = null, isNextPage: Boolean = false) {

        if (isNextPage) {
            page += 1
        }

        bookListViewState.postLoading()
        getBooksUseCase(
            params = GetBooksUseCase.Params(
                bookTitle = bookTitle,
                page = page
            ),
            onSuccess = { bookList ->
                bookListViewState.postSuccess(Pair(bookList, isNextPage))
            },
            onError = { error ->
                bookListViewState.postError(error)
            }
        )
    }

    fun saveBooks(bookList: List<Book>) {
        saveBooksUseCase(
            params = SaveBooksUseCase.Params(
                bookList = bookList
            )
        )
    }
}