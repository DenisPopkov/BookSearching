package ru.popkov.ui.screens.search

import android.icu.text.SearchIterator
import android.util.Log
import ru.popkov.domain.ext.launchUI
import moxy.InjectViewState
import ru.popkov.domain.ext.withIO
import ru.popkov.domain.interactors.BookInteractor
import ru.popkov.domain.model.BookModel
import ru.popkov.domain.net.BookNetRepository
import ru.popkov.ui.common.mvp.base.BasePresenter
import ru.popkov.ui.navigation.Screens

@InjectViewState
class SearchPresenter() : BasePresenter<ApartmentCardView>() {

    private lateinit var bookInteractor: BookInteractor
    private var bookModel: BookModel? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        launchUI(handler) {
            val book = withIO { bookInteractor.getAllBooks("Доктор") }
            val bookList = book.await()
            bookModel = bookList.first()
            viewState.showApartment(bookModel!!)
            Log.d("efefe", bookList.first().toString())
        }
    }

    fun navigateToArticle() {
        router.navigateTo(Screens.Filter())
    }
}