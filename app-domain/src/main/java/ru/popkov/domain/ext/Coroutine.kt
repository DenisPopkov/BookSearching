package ru.popkov.domain.ext

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

fun CoroutineScope.launchUI(callback: suspend () -> Unit) = launch(Dispatchers.Main) { callback() }

fun CoroutineScope.launchUI(handler: CoroutineExceptionHandler, callback: suspend () -> Unit) =
    launch(Dispatchers.Main + handler) { callback() }

fun CoroutineScope.launchIO(callback: suspend () -> Unit) = launch(Dispatchers.IO) { callback() }

fun CoroutineScope.launchIO(handler: CoroutineExceptionHandler, callback: suspend () -> Unit) =
    launch(Dispatchers.IO + handler) { callback() }

suspend fun <T> withIO(callback: suspend () -> T) = withContext(Dispatchers.IO) { callback() }

fun <T> CoroutineScope.asyncIO(callback: suspend () -> T) = async(Dispatchers.IO) { callback() }

fun <T> Flow<T>.flowOnIO() = flowOn(Dispatchers.IO)