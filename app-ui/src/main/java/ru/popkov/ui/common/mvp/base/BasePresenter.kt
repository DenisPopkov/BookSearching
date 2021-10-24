package ru.popkov.ui.common.mvp.base

import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.popkov.ui.common.exceptions.PresenterExceptions
import ru.popkov.ui.common.exceptions.createExceptionHandler

abstract class BasePresenter<View : BaseView>
    : MvpPresenter<View>(), CoroutineScope, KoinComponent, PresenterExceptions {

    private val job = SupervisorJob()
    override val coroutineContext = Dispatchers.Main + job

    protected val router: Router by inject()
    protected val handler by lazy { createExceptionHandler(::onException) }

    override fun onNoInternetException() {
        viewState.showNoInternetAlert()
    }

    override fun onServerException() {
        viewState.showServerAlert()
    }

    override fun onUnknownException(exception: Throwable) {
        viewState.showUnknownAlert(exception.message)
    }

    open fun onException(throwable: Throwable) {
        throwable.printStackTrace()
    }

    open fun onBackPressed() {
        router.exit()
    }
}