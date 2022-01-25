package com.lucasfagundes.ioasysbooks.feature.login.model

data class Book(
    val id: Int,
    val title:String,
    val author: String = "Lucas Fagundes",
    val pages: String = "150 paginas",
    val publisher: String = "Sao Paulo Ed",
    val date: String = "02/10/1995",
){
    companion object{
        fun getMockList() = listOf(
            Book(
                id = 1,
                title = "asdasdasd"
            ),
            Book(
                id = 2,
                title = "ertertert"
            ),
            Book(
                id = 3,
                title = "uiouiouio"
            ),
            Book(
                id = 4,
                title = "jkljkljkl"
            ),
            Book(
                id = 5,
                title = "qweqweqwe"
            )
        )


    }
}


