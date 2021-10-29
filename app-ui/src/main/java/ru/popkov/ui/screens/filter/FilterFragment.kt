package ru.popkov.ui.screens.filter

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.inject
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.databinding.FragmentFilterBinding

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
        val adapter = mutableMapOf(
            resources.getString(R.string.all_search) to 0, resources.getString(R.string.by_author) to 0,
            resources.getString(R.string.by_title) to 0, resources.getString(R.string.by_genre) to 0,
            resources.getString(R.string.by_publisher) to 0
        )
        val pos = when(filter) {
            resources.getString(R.string.all_search) -> 0
            resources.getString(R.string.by_author) -> 1
            resources.getString(R.string.by_title) -> 2
            resources.getString(R.string.by_genre) -> 3
            resources.getString(R.string.by_publisher) -> 4
            else -> 0
        }
        adapter[filter] = pos
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