package ru.popkov.ui.screens.search

import android.content.Context
import ru.popkov.domain.ext.launchUI
import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.model.Item
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.common.storage.getFilterParameter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class SearchPresenter : BasePresenter<SearchView>() {

    private val bookInteractor: BookInteractor by inject()
    private var books: MutableList<BookResponse> = mutableListOf()

    fun loadData(request: String, context: Context) {
        val filter = getFilterParameter(context)
        launchUI {
            val book = withIO {
                when (filter) {
                    "Поиск по всему" -> bookInteractor.getAllBooks(request)
                    "Поиск по автору" -> bookInteractor.getBooksByAuthor(request)
                    "Поиск по названию" -> bookInteractor.getBooks(request)
                    "Поиск по жанру" -> bookInteractor.getBooksGenre(request)
                    "Поиск по издателю" -> bookInteractor.getBooksPublisher(request)
                    else -> bookInteractor.getAllBooks(request)
                }
            }
            books.addAll(mutableListOf(book))
            viewState.showBookList(book.items!!)
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