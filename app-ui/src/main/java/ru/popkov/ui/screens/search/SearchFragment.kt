package ru.popkov.ui.screens.search

import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.popkov.domain.model.BookModel
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding
import ru.popkov.ui.screens.search.viewholder.SearchViewHolder

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
                SearchViewHolder(it, requireContext())
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