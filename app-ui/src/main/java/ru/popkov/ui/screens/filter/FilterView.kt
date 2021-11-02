package ru.popkov.ui.screens.filter

import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.popkov.ui.common.mvp.base.BaseView
import ru.popkov.ui.model.FilterModel

interface FilterView : BaseView {

    @AddToEndSingle
    fun updateFilterAdapter(data: List<FilterModel>)
}
