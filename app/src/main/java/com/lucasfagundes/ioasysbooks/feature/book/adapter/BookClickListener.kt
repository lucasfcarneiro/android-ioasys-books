package com.lucasfagundes.ioasysbooks.feature.book.adapter

import com.lucasfagundes.ioasysbooks.feature.book.model.Book

interface BookClickListener {
    fun onBookClickListener(book: Book)
}