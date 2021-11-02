package ru.popkov.domain.interactors

import ru.popkov.domain.storage.IFilterInteractor
import ru.popkov.domain.storage.PreferencesFilter

class FilterInteractor(private val repo: PreferencesFilter) : IFilterInteractor {
    override fun setFilterParameter(filter: String) = repo.setFilterParameter(filter)

    override fun getFilterParameter() = repo.getFilterParameter()
}
