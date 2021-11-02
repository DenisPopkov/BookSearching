package ru.popkov.ui.screens.search

import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.ext.launchUI
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.storage.IFilterInteractor
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens
import ru.popkov.ui.model.Filters

@InjectViewState
class SearchPresenter : BasePresenter<SearchView>() {

    private val bookInteractor: BookInteractor by inject()
    private var books: MutableList<BookResponse> = mutableListOf()
    private val filterInteractor: IFilterInteractor by inject()

    private fun loadData(request: String) {
        val filter = filterInteractor.getFilterParameter()?.let { Filters.valueOf(it) }
        launchUI {
            val book = withIO {
                when (filter) {
                    Filters.AUTHOR -> bookInteractor.getBooks("inauthor:$request")
                    Filters.TITLE -> bookInteractor.getBooks("intitle:$request")
                    Filters.GENRE -> bookInteractor.getBooks("subject:$request")
                    Filters.PUBLISHER -> bookInteractor.getBooks("inpublisher:$request")
                    else -> bookInteractor.getBooks(request)
                }
            }
            books.addAll(mutableListOf(book))
            viewState.showBookList(book.items ?: emptyList())
        }
    }

    fun createRequest(request: String) {
        if (request.isNotEmpty()) {
            loadData(request)
        } else {
            clearData()
        }
    }

    fun clearData() {
        launchUI {
            books.clear()
            viewState.showBookList(emptyList())
        }
    }

    fun navigationToFilter() {
        router.navigateTo(Screens.Filter())
    }
}
