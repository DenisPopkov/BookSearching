package ru.popkov.ui.screens.details

import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.popkov.domain.model.Item
import ru.popkov.ui.common.mvp.base.BaseView

interface DetailView: BaseView {

    @AddToEndSingle
    fun showBook(item: List<Item>)
}