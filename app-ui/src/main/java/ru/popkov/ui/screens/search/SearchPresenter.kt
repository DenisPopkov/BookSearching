package ru.popkov.ui.screens.search

import android.content.Context
import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.ext.launchUI
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.navigation.Screens
import ru.popkov.ui.utils.Filters

@InjectViewState
class SearchPresenter : BasePresenter<SearchView>() {

    private val bookInteractor: BookInteractor by inject()
    private var books: MutableList<BookResponse> = mutableListOf()
    private val filters: IPreference by inject()

    fun loadData(request: String, context: Context) {
        val filter = filters.getFilterParameter().toString()
        launchUI {
            val book = withIO {
                when (filter) {
                    context.getString(Filters.AUTHOR.res) -> bookInteractor.getBooks("inauthor:$request")
                    context.getString(Filters.TITLE.res) -> bookInteractor.getBooks("intitle:$request")
                    context.getString(Filters.GENRE.res) -> bookInteractor.getBooks("subject:$request")
                    context.getString(Filters.PUBLISHER.res) -> bookInteractor.getBooks("inpublisher:$request")
                    else -> bookInteractor.getBooks(request)
                }
            }
            books.addAll(mutableListOf(book))
            viewState.showBookList(book.items ?: emptyList())
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