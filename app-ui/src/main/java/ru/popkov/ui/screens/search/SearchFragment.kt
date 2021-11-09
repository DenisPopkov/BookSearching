package ru.popkov.ui.screens.search

import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import ru.popkov.domain.model.Item
import ru.popkov.domain.storage.IFilterInteractor
import ru.popkov.ui.R
import ru.popkov.ui.common.ext.createUserRequestWithDelay
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding
import ru.popkov.ui.model.Filters
import ru.popkov.ui.screens.search.viewholder.SearchViewHolder
import java.util.*

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate),
    SearchView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    private val interactor: IFilterInteractor by inject()

    private lateinit var bookForDetail: List<Item>

    private val bookAdapter by lazy {
        SimpleAdapter(
            BookItemBinding::inflate,
            createViewHolder = { SearchViewHolder(it, requireContext()) },
            onClickCallback = { _, pos -> presenter.navigateToDetailScreen(bookForDetail[pos]) }
        )
    }

    override fun initViews() {
        initListeners()
        setAdapter()
        filterChangedBehavior()
    }

    private fun filterChangedBehavior() {
        val filter = interactor.getFilterParameter()?.let { Filters.valueOf(it) }

        if (filter != null && filter != Filters.ALL) {
            binding.filterButton.setImageResource(R.drawable.filter_badge_icon)
        }

        binding.emptyRequest.isVisible = bookAdapter.items.isEmpty()
    }

    private fun setAdapter() {
        binding.bookRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.bookRecycler.adapter = bookAdapter
    }

    override fun showBookList(items: List<Item>) {
        bookForDetail = items.toMutableList()
        bookAdapter.swapItems(items.toMutableList())
        binding.emptyRequest.isVisible = items.isEmpty()
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    private fun initListeners() {

        binding.filterButton.setOnClickListener { presenter.navigationToFilter() }

        binding.clearButton.setOnClickListener {
            binding.searchUserField.setText("")
            presenter.clearData()
            binding.emptyRequest.visibility = View.VISIBLE
        }

        binding.searchUserField.setOnKeyListener { _, keyCode, keyEvent ->
            val currentUserBookRequest = binding.searchUserField.text.toString()
            presenter.onKeyboardEnterButtonPushed(keyEvent, keyCode, currentUserBookRequest)
            return@setOnKeyListener true
        }

        binding.searchUserField.createUserRequestWithDelay().debounce(1500).onEach {
            val currentUserBookRequest = binding.searchUserField.text.toString()
            presenter.createRequest(currentUserBookRequest)
            binding.clearButton.isInvisible = currentUserBookRequest.isEmpty()
        }.launchIn(lifecycleScope)
    }
}
