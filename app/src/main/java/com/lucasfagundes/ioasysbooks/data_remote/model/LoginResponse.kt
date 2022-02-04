package com.lucasfagundes.ioasysbooks.data_remote.model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("name")
    val name : String,
    @SerializedName("birthday")
    val birthday : String,
    @SerializedName("gender")
    val gender : String,
    @SerializedName("id")
    val id : String
    )
