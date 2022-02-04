package com.lucasfagundes.ioasysbooks.domain.model

data class Book(
    val id: String,
    val title:String,
    val author: String = "",
    val pages: String = "",
    val publisher: String = "",
    val originName:String ="",
    val publicationDate: String = "",
    val isbn10: String = "",
    val isbn13 : String = "",
    val language : String = "",
    val review : String = "",
    val imageUrl: String
)




