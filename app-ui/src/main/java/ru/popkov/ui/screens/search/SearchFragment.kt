package ru.popkov.ui.screens.search

import kotlinx.android.synthetic.main.parameter_item.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.popkov.domain.model.Item
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding
import ru.popkov.ui.screens.search.viewholder.SearchViewHolder

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate),
    SearchView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    @ProvidePresenter
    fun providePresenter(): SearchPresenter {

        return SearchPresenter()
    }

    private val bookAdapter by lazy {
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

    override fun showBookList(book: List<Item>) {
        bookAdapter.swapItems(listOf(book))
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
        binding.bookRecycler.adapter = bookAdapter
    }
}