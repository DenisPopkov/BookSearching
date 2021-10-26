package ru.popkov.ui.screens.search

import ru.popkov.domain.ext.launchUI
import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.model.Item
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class SearchPresenter : BasePresenter<SearchView>() {

    private val bookInteractor: BookInteractor by inject()
    private var books: MutableList<Item> = mutableListOf()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        launchUI {
            val book = withIO { bookInteractor.getBooksByAuthor("king") }
            viewState.showBookList(book.items!!)

            if (book.items!!.isNotEmpty()) {
                books.addAll(book.items!!)
                viewState.showBookList(books)
            }
        }
    }

    fun navigationToFilter() {
        router.navigateTo(Screens.Filter())
    }
}



