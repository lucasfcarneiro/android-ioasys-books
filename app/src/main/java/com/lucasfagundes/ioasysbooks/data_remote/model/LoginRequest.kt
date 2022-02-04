package com.lucasfagundes.ioasysbooks.data_remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("mail")
    val mail:String,
    @SerializedName("password")
    val password :String
)