package com.lucasfagundes.ioasysbooks.feature.login.presentation.adapter

import com.lucasfagundes.ioasysbooks.feature.login.model.Book

interface BookClickListener {
    fun onBookClickListener(book:Book)
}