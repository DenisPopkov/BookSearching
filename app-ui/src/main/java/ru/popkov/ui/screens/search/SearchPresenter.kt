package ru.popkov.ui.screens.search

import ru.popkov.domain.ext.launchUI
import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.model.BookResponse
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class SearchPresenter : BasePresenter<SearchView>() {

    private val bookInteractor: BookInteractor by inject()
    private var books: MutableList<BookResponse> = mutableListOf()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun loadData(request: String) {
        launchUI {
            val book = withIO { bookInteractor.getAllBooks(request) }
            books.addAll(mutableListOf(book))
            viewState.showBookList(book.items!!)
        }
    }

    fun navigationToFilter() {
        router.navigateTo(Screens.Filter())
    }
}