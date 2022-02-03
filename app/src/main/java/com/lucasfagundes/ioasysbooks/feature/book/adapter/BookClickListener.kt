package com.lucasfagundes.ioasysbooks.feature.book.adapter

import com.lucasfagundes.ioasysbooks.domain.model.Book

interface BookClickListener {
    fun onBookClickListener(book: Book)
}