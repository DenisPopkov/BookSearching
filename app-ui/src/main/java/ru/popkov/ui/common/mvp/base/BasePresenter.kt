package ru.popkov.ui.common.mvp.base

import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import moxy.MvpPresenter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BasePresenter<View : BaseView>
    : MvpPresenter<View>(), CoroutineScope, KoinComponent {

    private val job = SupervisorJob()
    override val coroutineContext = Dispatchers.Main + job

    protected val router: Router by inject()

    open fun onException(throwable: Throwable) {
        throwable.printStackTrace()
    }

    open fun onBackPressed() {
        router.exit()
    }
}