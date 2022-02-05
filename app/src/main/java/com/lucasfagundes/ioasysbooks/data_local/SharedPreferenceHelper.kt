package com.lucasfagundes.ioasysbooks.data_local

import android.content.Context
import com.lucasfagundes.ioasysbooks.utils.LocalConstants

class SharedPreferenceHelper(context:Context) {

    private val sharedPreferences = context.getSharedPreferences(
        LocalConstants.SHARED_PREFERENCES_NAME,
         Context.MODE_PRIVATE
    )

    fun saveString(key:String, value:String) = sharedPreferences.edit().run {
        putString(key,value)
        apply()
    }

    fun getString(key:String):String = sharedPreferences.getString(key,"") ?: ""

    }
