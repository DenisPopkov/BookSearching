package ru.popkov.ui.screens.filter

import moxy.InjectViewState
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class FilterPresenter() : BasePresenter<FilterView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun navigationToSearch(parameter: String) {
        router.backTo(Screens.Search(parameter))
    }
}