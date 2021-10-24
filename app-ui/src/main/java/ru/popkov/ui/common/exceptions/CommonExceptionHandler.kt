package ru.popkov.ui.common.exceptions

import kotlinx.coroutines.CoroutineExceptionHandler
import ru.popkov.domain.exceptions.NoInternetException
import ru.popkov.domain.exceptions.ServerException

class CommonExceptionHandler(
    private val onException: ((Throwable) -> Unit)? = null,
    private val basicExceptions: PresenterExceptions
) {

    val coroutineHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        onException?.invoke(throwable)
        when (throwable) {
            is NoInternetException -> basicExceptions.onNoInternetException()
            is ServerException -> basicExceptions.onServerException()
        }
    }
}

fun PresenterExceptions.createExceptionHandler(onException: (Throwable) -> Unit) =
    CommonExceptionHandler(onException, this).coroutineHandler
