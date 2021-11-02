package ru.popkov.ui.screens.filter

import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.storage.IFilterInteractor
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.model.Filters

@InjectViewState
class FilterPresenter : BasePresenter<FilterView>() {

    private val interactor: IFilterInteractor by inject()

    private val filters = listOf(
        FilterModel(Filters.ALL, true),
        FilterModel(Filters.AUTHOR, false),
        FilterModel(Filters.TITLE, false),
        FilterModel(Filters.GENRE, false),
        FilterModel(Filters.PUBLISHER, false)
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        initData()
    }

    private fun initData() {
        val currentFilter = interactor.getFilterParameter()?.let { Filters.valueOf(it) }
        currentFilter?.let { setChecked(it) }

        viewState.updateFilterAdapter(filters)
    }

    private fun setChecked(item: Filters) {
        filters.forEach { it.filterCheck = false }
        filters.find { it.parameter == item }?.filterCheck = true
    }

    fun navigationToSearch() {
        router.exit()
    }

    fun onClickFilter(item: FilterModel) {
        interactor.setFilterParameter(item.parameter.name)
        setChecked(item.parameter)
        viewState.updateFilterAdapter(filters)
    }
}
