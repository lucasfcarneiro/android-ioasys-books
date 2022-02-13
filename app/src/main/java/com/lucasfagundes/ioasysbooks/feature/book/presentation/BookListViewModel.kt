package com.lucasfagundes.ioasysbooks.feature.book.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import com.lucasfagundes.ioasysbooks.domain.use_case.GetBookListUseCase
import com.lucasfagundes.ioasysbooks.domain.use_case.SaveBooksUseCase
import com.lucasfagundes.ioasysbooks.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import kotlin.Exception

class BookListViewModel(
    private val getBookListUseCase: GetBookListUseCase,
    private val saveBooksUseCase: SaveBooksUseCase
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        _bookListViewState.postLoading()
        getBookListUseCase(
            params = GetBookListUseCase.Params(
                input = input
            ),
            onSuccess = { bookList ->
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