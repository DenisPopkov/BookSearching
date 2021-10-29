package ru.popkov.ui.screens.filter

import moxy.InjectViewState
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens
import ru.popkov.ui.screens.search.SearchFragment

@InjectViewState
class FilterPresenter : BasePresenter<FilterView>() {

    fun navigationToSearch() {
        router.exit()
    }
}