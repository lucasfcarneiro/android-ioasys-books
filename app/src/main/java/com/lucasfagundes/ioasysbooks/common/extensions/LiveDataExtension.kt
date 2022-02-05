package com.lucasfagundes.ioasysbooks.common.extensions

import androidx.lifecycle.MutableLiveData
import com.lucasfagundes.ioasysbooks.common.utils.ViewState
import kotlin.Exception

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState.Success(data))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Exception) {
    postValue(ViewState.Error(error))
}

fun <T> MutableLiveData<ViewState<T>>.postNeutral() {
    postValue(ViewState.Neutral)
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    postValue(ViewState.Loading)
}