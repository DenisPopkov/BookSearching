package ru.popkov.ui.screens.filter

import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import org.koin.android.ext.android.inject
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.databinding.FragmentFilterBinding
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.utils.Filters

class FilterFragment : BaseFragment<FragmentFilterBinding>(FragmentFilterBinding::inflate),
    FilterView {

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    private val filters: IPreference by inject()

    private fun initAdapters() {

        val whichChecked = when(filters.getFilterParameter().toString()) {
            getString(Filters.AUTHOR.res) -> 1
            getString(Filters.TITLE.res) -> 2
            getString(Filters.GENRE.res) -> 3
            getString(Filters.PUBLISHER.res) -> 4
            else -> 0
        }

        val adapter = mutableListOf(
            FilterModel(getString(Filters.ALL.res), whichChecked),
            FilterModel(getString(Filters.AUTHOR.res), whichChecked),
            FilterModel(getString(Filters.TITLE.res), whichChecked),
            FilterModel(getString(Filters.GENRE.res), whichChecked),
            FilterModel(getString(Filters.PUBLISHER.res), whichChecked)
        )

        binding.bookFilter.layoutManager = LinearLayoutManager(requireContext())
        binding.bookFilter.adapter = FilterResAdapter(adapter, filters)

        binding.backToSearch.setOnClickListener {
            presenter.navigationToSearch()
        }
    }

    override fun initViews() {
        initAdapters()
    }
}