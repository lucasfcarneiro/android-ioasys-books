package com.lucasfagundes.ioasysbooks.domain.model

data class Book(
    val id: Int,
    val title:String,
    val author: String = "Lucas Fagundes",
    val pages: String = "150 paginas",
    val publisher: String = "Sao Paulo Ed",
    val publicationDate: String = "02/10/1995",
    val isbn10: String = "54621616",
    val isbn13 : String = "874965196",
    val language : String = "Ingles",
    val review : String = "Mussum Ipsum, cacilds vidis litro abertis. Manduma pindureta quium dia nois paga.Sapien in monti palavris qui num significa nadis i pareci latim.Quem num gosta di mé, boa gentis num é.Quem manda na minha terra sou euzis!"
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


