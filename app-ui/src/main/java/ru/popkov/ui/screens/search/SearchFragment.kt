package ru.popkov.ui.screens.search

import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.popkov.domain.model.BookModel
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding
import ru.popkov.ui.screens.search.viewholder.SearchViewHolder

class SearchFragment(filterParameter: String) :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate),
    SearchView {

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
            }, null
        )
    }

    override fun initViews() {
        initAdapters()
        setListeners()
    }

    override fun showBookList(items: List<BookModel>) {
        apartmentTypesAdapter.swapItems(items)
    }

    private fun setListeners() {
        binding.apply {
            filterButton.setOnClickListener { presenter.navigationToFilter() }
        }
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