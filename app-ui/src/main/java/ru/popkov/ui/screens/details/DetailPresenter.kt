package ru.popkov.ui.screens.details

import moxy.InjectViewState
import ru.popkov.ui.common.mvp.base.BasePresenter

@InjectViewState
class DetailPresenter : BasePresenter<DetailView>() {

    fun navigateToSearch() {
        router.exit()
    }
}