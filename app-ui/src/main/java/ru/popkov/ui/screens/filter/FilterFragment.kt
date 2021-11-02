package ru.popkov.ui.screens.filter

import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.FragmentFilterBinding
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.screens.filter.viewholder.FilterViewHolder

class FilterFragment : BaseFragment<FragmentFilterBinding>(FragmentFilterBinding::inflate),
    FilterView {

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    private val filterAdapter by lazy {
        SimpleAdapter(
            ParameterItemBinding::inflate,
            createViewHolder = { FilterViewHolder(it) },
            onClickCallback = { item, _ -> presenter.onClickFilter(item) }
        )
    }

    override fun updateFilterAdapter(data: List<FilterModel>) {
        filterAdapter.swapItems(data)
    }

    override fun initViews() {
        initAdapters()
        initListeners()
    }

    private fun initAdapters() {
        binding.filterBook.layoutManager = LinearLayoutManager(requireContext())
        binding.filterBook.adapter = filterAdapter
    }

    private fun initListeners() {
        binding.backToSearchScreen.setOnClickListener {
            presenter.navigationToSearch()
        }
    }
}
