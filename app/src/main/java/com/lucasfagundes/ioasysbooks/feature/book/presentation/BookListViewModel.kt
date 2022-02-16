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

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    init {
        getBooks()
    }

    fun getBooks(bookTitle: String? = null) {
        _bookListViewState.postLoading()
        getBooksUseCase(
            params = GetBooksUseCase.Params(
                bookTitle = bookTitle
            ),
            onSuccess = { bookList ->
                saveBooks(bookList = bookList)
                _bookListViewState.postSuccess(bookList)
            },
            onError = { error ->
                _bookListViewState.postError(error)
            }
        )
    }

    private fun saveBooks(bookList: List<Book>) {
        saveBooksUseCase(
            params = SaveBooksUseCase.Params(
                bookList = bookList
            )
        )
    }
}