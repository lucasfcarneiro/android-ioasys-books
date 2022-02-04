package com.lucasfagundes.ioasysbooks.data_remote.mappers

import com.lucasfagundes.ioasysbooks.data_remote.model.BookResponse
import com.lucasfagundes.ioasysbooks.domain.model.Book

fun List<BookResponse>.todomain():List<Book>{
    return this.map {book->
        Book(
            id = book.id?:"",
            title = book.title?:"",
            author = book.author?.first()?:"",
            pages = book.pages?:"",
            publisher = book.publisher?:"",
            originName = book.title?:"",
            isbn10 = book.isbn10?:"",
            isbn13 = book.isbn13?:"",
            language = book.language?:"",
            publicationDate = book.publicationDate?:"",
            review = book.review?:"",
            imageUrl = book.imageUrl?:"",
        )
    }
}