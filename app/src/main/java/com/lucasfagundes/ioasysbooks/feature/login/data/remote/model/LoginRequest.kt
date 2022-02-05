package com.lucasfagundes.ioasysbooks.feature.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("email")
    val mail:String,
    @SerializedName("password")
    val password :String
)
