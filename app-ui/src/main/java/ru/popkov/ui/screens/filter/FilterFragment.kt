package ru.popkov.ui.screens.filter

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.FragmentFilterBinding
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.screens.filter.viewholder.FilterViewHolder
import ru.popkov.ui.utils.Filters

class FilterFragment : BaseFragment<FragmentFilterBinding>(FragmentFilterBinding::inflate),
    FilterView {

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    private val filtersPreferences: IPreference by inject()

    private val filterAdapter by lazy {
        SimpleAdapter(
            ParameterItemBinding::inflate,
            createViewHolder = { FilterViewHolder(it) },
            onClickCallback = { item, _ ->
                filtersPreferences.createPreferencesFile(item.parameter)
                initAdapters()
            }
        )
    }

    private fun createFilterAdapter(): MutableList<FilterModel> {
        val whichChecked = when(filtersPreferences.getFilterParameter().toString()) {
            getString(Filters.AUTHOR.res) -> 1
            getString(Filters.TITLE.res) -> 2
            getString(Filters.GENRE.res) -> 3
            getString(Filters.PUBLISHER.res) -> 4
            else -> 0
        }

        return mutableListOf(
            FilterModel(getString(Filters.ALL.res), whichChecked),
            FilterModel(getString(Filters.AUTHOR.res), whichChecked),
            FilterModel(getString(Filters.TITLE.res), whichChecked),
            FilterModel(getString(Filters.GENRE.res), whichChecked),
            FilterModel(getString(Filters.PUBLISHER.res), whichChecked)
        )
    }

    private fun updateFilterAdapter() {
        filterAdapter.swapItems(createFilterAdapter())
    }

    private fun initListeners() {
        binding.backToSearchScreen.setOnClickListener {
            presenter.navigationToSearch()
        }
    }

    private fun initAdapters() {
        updateFilterAdapter()
        binding.filterBook.layoutManager = LinearLayoutManager(requireContext())
        binding.filterBook.adapter = filterAdapter
    }

    override fun initViews() {
        initAdapters()
        initListeners()
    }
}