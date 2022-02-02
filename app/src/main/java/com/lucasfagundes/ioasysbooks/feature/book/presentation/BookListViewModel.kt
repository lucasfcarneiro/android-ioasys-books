package com.lucasfagundes.ioasysbooks.feature.book.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasfagundes.ioasysbooks.feature.book.model.Book
import com.lucasfagundes.ioasysbooks.utils.EmptyBookListException
import com.lucasfagundes.ioasysbooks.utils.ViewState
import com.lucasfagundes.ioasysbooks.utils.postError
import com.lucasfagundes.ioasysbooks.utils.postSuccess
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    private val bookDataList: List<Book> by lazy { Book.getMockList() }


    private fun getBooks(input: String): List<Book> {
        return if (input.trim().isEmpty()) {
            bookDataList
        } else {
            bookDataList.filter { book ->
                book.title.trim().contains(input, ignoreCase = true) }
        }
    }

    fun search(input: String = "") {
        viewModelScope.launch {
            getBooks(input).let { book ->
                when {
                    book.isNotEmpty() -> {
                        _bookListViewState.postSuccess(book)
                    }
                    else -> {
                        _bookListViewState.postError(EmptyBookListException())
                    }
                }
            }
        }
    }
}