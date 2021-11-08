package ru.popkov.ui.screens.details

import moxy.InjectViewState
import ru.popkov.domain.model.Item
import ru.popkov.ui.common.mvp.base.BasePresenter

@InjectViewState
class DetailPresenter: BasePresenter<DetailView>() {

    fun getData() {
        router.setResultListener("detail") { data ->
            viewState.showBook(data as List<Item>)
        }
    }

    fun navigateToSearch() {
        router.exit()
    }
}