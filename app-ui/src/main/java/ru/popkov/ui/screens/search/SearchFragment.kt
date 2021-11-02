package ru.popkov.ui.screens.search

import android.view.KeyEvent
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import ru.popkov.domain.model.Item
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R
import ru.popkov.ui.common.ext.createUserRequestWithDelay
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding
import ru.popkov.ui.screens.search.viewholder.SearchViewHolder
import java.util.*

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate),
    SearchView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    private val filters: IPreference by inject()

    private val bookAdapter by lazy {
        SimpleAdapter(BookItemBinding::inflate,
            createViewHolder = { SearchViewHolder(it, requireContext()) },
            onClickCallback = { item, _ -> presenter.navigationToFilter() }
        )
    }

    override fun initViews() {
        setListeners()
        binding.bookRecycler.adapter = bookAdapter

        val filter = filters.getFilterParameter().toString()

        if (filter.isNotEmpty() && filter != "Поиск по всему") {
            binding.filterButton.setImageResource(R.drawable.filter_badge_icon)
        }

        if (bookAdapter.items.isEmpty()) binding.emptyRequest.visibility = View.VISIBLE
    }

    override fun showBookList(items: List<Item>?) {
        bookAdapter.swapItems(items!!.toMutableList())
        if (items.isNotEmpty()) binding.emptyRequest.visibility = View.GONE
    }

    private fun clearScreen() {
        presenter.clearData()
        binding.emptyRequest.visibility = View.VISIBLE
    }

    private fun createRequest() {
        if (binding.searchUserField.text.toString().isNotEmpty()) {
            presenter.loadData(binding.searchUserField.text.toString(), requireContext())
        } else {
            clearScreen()
        }
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    private fun setListeners() {
        binding.apply {
            filterButton.setOnClickListener { presenter.navigationToFilter() }
        }

        binding.clearButton.setOnClickListener {
            binding.searchUserField.setText("")
            clearScreen()
        }

        binding.searchUserField.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                createRequest()
            }
            return@setOnKeyListener true
        }

        binding.searchUserField.createUserRequestWithDelay().debounce(1500).onEach {
            createRequest()
            binding.clearButton.isInvisible = it.toString().isEmpty()
        }.launchIn(lifecycleScope)
    }
}