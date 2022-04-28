package com.woojoo.kbanktest.extension

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.request(
    block: suspend CoroutineScope.() -> Unit
) {
    val coroutineException = CoroutineExceptionHandler { _, throwable ->
        Log.d("Connect Error : ", "${throwable}")
    }
    this.launch (coroutineException) {
        block.invoke(this)
    }
}