package com.lucasfagundes.ioasysbooks.di

import com.lucasfagundes.ioasysbooks.feature.book.presentation.BookListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bookPresentationModule = module {
    viewModel {
        BookListViewModel(get(),get())
    }
}