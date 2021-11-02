package ru.popkov.domain.storage

interface IFilterInteractor {

    fun setFilterParameter(filter: String)
    fun getFilterParameter(): String?
}
