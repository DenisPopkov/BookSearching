package ru.popkov.ui.screens.filter

import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.inject
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.databinding.FragmentFilterBinding
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.screens.filter.viewholder.FilterResAdapter
import ru.popkov.ui.utils.Filters

class FilterFragment : BaseFragment<FragmentFilterBinding>(FragmentFilterBinding::inflate),
    FilterView {

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    private val filters: IPreference by inject()

    @ProvidePresenter
    fun providePresenter(): FilterPresenter {

        return FilterPresenter()
    }

    private fun initAdapters() {
        val filter = filters.getFilterParameter().toString()

        val whichChecked = when(filter) {
            getString(Filters.ALL.res) -> true
            getString(Filters.ALL.res) -> true
            getString(Filters.TITLE.res) -> true
            getString(Filters.GENRE.res) -> true
            getString(Filters.PUBLISHER.res) -> true
            else -> false
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

    override fun showNoInternetAlert() {
        //do nothing
    }

    override fun showServerAlert() {
        //do nothing
    }

    override fun showUnknownAlert(message: String?) {
        //do nothing
    }

    override fun initViews() {
        initAdapters()
    }
}