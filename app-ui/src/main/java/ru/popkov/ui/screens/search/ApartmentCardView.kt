package ru.popkov.ui.screens.search


import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.popkov.domain.model.BookModel
import ru.popkov.ui.common.mvp.base.BaseView

interface ApartmentCardView : BaseView {
    @AddToEndSingle
    fun showApartment(apartment: BookModel)
}