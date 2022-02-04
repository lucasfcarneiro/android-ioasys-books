package com.lucasfagundes.ioasysbooks.domain.model

data class User(
    val name: String,
    val birthday: String,
    val gender: String,
    val accessToken: String,
    val id: String
)