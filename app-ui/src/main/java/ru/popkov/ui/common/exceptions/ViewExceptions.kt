package ru.popkov.ui.common.exceptions

import moxy.viewstate.strategy.alias.OneExecution

interface ViewExceptions {

    @OneExecution
    fun showNoInternetAlert()

    @OneExecution
    fun showServerAlert()

    @OneExecution
    fun showUnknownAlert(message: String? = null)
}
