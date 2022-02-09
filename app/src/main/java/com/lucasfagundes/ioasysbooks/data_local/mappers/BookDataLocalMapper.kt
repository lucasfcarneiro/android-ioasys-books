package com.lucasfagundes.ioasysbooks.data_local.mappers

import com.lucasfagundes.ioasysbooks.data_local.model.BookDataLocal
import com.lucasfagundes.ioasysbooks.domain.model.Book

fun Book.toDao(): BookDataLocal = BookDataLocal(
    id = this.id,
    title = this.title,
    author = this.author,
    pages = this.pages,
    publisher = this.publisher,
    originName = this.originName,
    publicationDate = this.publicationDate,
    isbn10 = this.isbn10,
    isbn13 = this.isbn13,
    language = this.language,
    review = this.review,
    imageUrl = this.imageUrl
)

fun BookDataLocal.toDomain(): Book=Book(
    id = this.id ?: "",
    title = this.title?: "",
    author = this.author?: "",
    pages = this.pages?: "",
    publisher = this.publisher?: "",
    originName = this.originName?: "",
    publicationDate = this.publicationDate?: "",
    isbn10 = this.isbn10?: "",
    isbn13 = this.isbn13?: "",
    language = this.language?: "",
    review = this.review?: "",
    imageUrl = this.imageUrl?: ""
)