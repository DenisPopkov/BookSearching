package ru.popkov.ui.screens.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import moxy.presenter.InjectPresenter
import ru.popkov.domain.model.Item
import ru.popkov.ui.R
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.storage.createPreferencesFile
import ru.popkov.ui.common.storage.getFilterParameter
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding
import ru.popkov.ui.screens.search.viewholder.SearchViewHolder

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate),
    SearchView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    private val bookAdapter by lazy {
        SimpleAdapter(BookItemBinding::inflate,
            createViewHolder = { SearchViewHolder(it, requireContext()) },
            onClickCallback = { item, _ -> presenter.navigationToFilter() }
        )
    }

    override fun initViews() {
        setListeners()
        binding.bookRecycler.adapter = bookAdapter

        val filter = getFilterParameter(requireContext())

        if (filter.isNotEmpty() && filter != "Поиск по всему") {
            binding.filterButton.setImageResource(R.drawable.filter_badge_icon)
        }

        if (bookAdapter.items.isEmpty()) binding.emptyRequest.visibility = View.VISIBLE
    }

    override fun showBookList(items: List<Item>) {
        bookAdapter.swapItems(items.toMutableList())
        if (items.isNotEmpty()) binding.emptyRequest.visibility = View.GONE
    }

    private fun setListeners() {
        binding.apply {
            filterButton.setOnClickListener { presenter.navigationToFilter() }
        }
        binding.clearButton.setOnClickListener {
            binding.userRequest.setText("")
            presenter.clearData()
            binding.emptyRequest.visibility = View.VISIBLE
        }
        binding.userRequest.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                presenter.loadData(binding.userRequest.text.toString(), requireContext())
            }
            return@setOnKeyListener true
        }
        binding.userRequest.addTextChangedListener {
            if (it.toString().isEmpty()) {
                binding.clearButton.visibility = View.INVISIBLE
            } else {
                binding.clearButton.visibility = View.VISIBLE
            }
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
}