package ru.popkov.ui.screens.search

import android.os.Bundle
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.popkov.domain.model.BookModel
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate),
    SelectionApartmentTypeView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    @ProvidePresenter
    fun providePresenter(): SearchPresenter {

        return SearchPresenter()
    }

    private val apartmentTypesAdapter by lazy {
        SimpleAdapter(BookItemBinding::inflate,
            createViewHolder = {
                ApartmentViewHolder(it, requireContext())
            }, onClickCallback = { type, _ ->
                presenter.navigateToArticle()
            }
        )
    }

    override fun initViews() {
        initAdapters()
    }

    override fun showApartmentTypesList(items: List<BookModel>) {
        apartmentTypesAdapter.swapItems(items)
    }

    override fun showNoInternetAlert() {
        TODO("Not yet implemented")
    }

    override fun showServerAlert() {
        TODO("Not yet implemented")
    }

    override fun showUnknownAlert(message: String?) {
        TODO("Not yet implemented")
    }

    private fun initAdapters() {
        binding.bookRecycler.adapter = apartmentTypesAdapter
    }
}