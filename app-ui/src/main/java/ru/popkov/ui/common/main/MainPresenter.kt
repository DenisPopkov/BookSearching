package ru.popkov.ui.common.main

import moxy.InjectViewState
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        openScreens()
    }

    private fun openScreens() {
        router.newRootScreen(Screens.Search())
    }
}