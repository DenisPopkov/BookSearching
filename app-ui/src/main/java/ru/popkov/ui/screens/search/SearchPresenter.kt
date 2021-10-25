package ru.popkov.ui.screens.search

import android.util.Log
import ru.popkov.domain.ext.launchUI
import moxy.InjectViewState
import org.koin.core.component.inject
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class SearchPresenter() : BasePresenter<SearchView>() {

    private val bookInteractor: BookInteractor by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        launchUI(handler) {
            val book = withIO { bookInteractor.getAllBooks("Доктор") }
            viewState.showBookList(book)
            Log.d("efefe", book.first().toString())
        }
    }

    fun navigationToFilter() {
        router.navigateTo(Screens.Filter())
    }
}