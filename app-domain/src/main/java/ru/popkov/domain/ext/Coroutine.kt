package ru.popkov.domain.ext

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

fun CoroutineScope.launchUI(callback: suspend () -> Unit) = launch(Dispatchers.Main) { callback() }

suspend fun <T> withIO(callback: suspend () -> T) = withContext(Dispatchers.IO) { callback() }