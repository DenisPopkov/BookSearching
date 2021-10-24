package ru.popkov.ui.common.exceptions

interface PresenterExceptions {

    fun onNoInternetException()

    fun onServerException()

    fun onUnknownException(exception: Throwable)
}
