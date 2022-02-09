package com.lucasfagundes.ioasysbooks.feature.book.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucasfagundes.ioasysbooks.domain.model.Book
import com.lucasfagundes.ioasysbooks.domain.repositories.BooksRepository
import com.lucasfagundes.ioasysbooks.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import kotlin.Exception

class BookListViewModel(private val booksRepository: BooksRepository) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {

        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(input).collect{
                    if(it.isNotEmpty()){
                        saveBooks(bookList = it)
                        _bookListViewState.postSuccess(it)
                    }else{
                        _bookListViewState.postError(Exception("algo deu errado"))
                    }
                }
            }catch (error:Exception){
                _bookListViewState.postError(error)
            }
        }
    }

    private fun saveBooks(bookList: List<Book>){
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    booksRepository.saveBooks(bookList = bookList)
                }
            }catch (err:Exception){
                print(err)
            }
        }
    }
}