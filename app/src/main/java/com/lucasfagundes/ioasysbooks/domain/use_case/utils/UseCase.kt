package com.lucasfagundes.ioasysbooks.domain.use_case.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.Exception

abstract class UseCase<in Params, out T>(
    private val scope:CoroutineScope
) {

    abstract fun run(params: Params? = null):Flow<T>

    operator fun invoke(
        params: Params,
        onSuccess: (T) -> Unit = {},
        onError: (Throwable) -> Unit = {}
    ){

        scope.launch(Dispatchers.IO) {
            try {
                run(params = params).collect {
                    withContext(Dispatchers.Main){
                        onSuccess.invoke(it)
                    }
                }
            }catch (err:Exception){
                withContext(Dispatchers.Main){
                    onError.invoke(err)
                }
            }
        }
    }
}