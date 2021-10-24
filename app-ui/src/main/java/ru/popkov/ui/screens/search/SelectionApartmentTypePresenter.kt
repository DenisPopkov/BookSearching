package ru.popkov.ui.screens.search

import moxy.InjectViewState
import ru.popkov.domain.model.BookModel
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class SelectionApartmentTypePresenter(private val properties: List<BookModel>) : BasePresenter<SelectionApartmentTypeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showApartmentTypesList(properties)
    }

    fun openFilter() {
        router.navigateTo(Screens.Filter())
    }
}