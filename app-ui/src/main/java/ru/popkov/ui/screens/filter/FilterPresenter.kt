package ru.popkov.ui.screens.filter

import moxy.InjectViewState
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens
import ru.popkov.ui.screens.search.SearchFragment

@InjectViewState
class FilterPresenter : BasePresenter<FilterView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun navigationToSearch(parameter: String) {
        router.backTo(Screens.Search(parameter))
        SearchFragment.RE = 1
    }
}