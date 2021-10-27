package ru.popkov.ui.screens.filter

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.views.recycler.SimpleAdapter
import ru.popkov.ui.databinding.FragmentFilterBinding
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.navigation.Screens
import ru.popkov.ui.screens.search.SearchFragment

class FilterFragment : BaseFragment<FragmentFilterBinding>(FragmentFilterBinding::inflate),
FilterView{

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    @ProvidePresenter
    fun providePresenter(): FilterPresenter {

        return FilterPresenter()
    }

    private fun initAdapters() {
        val adapter = arrayListOf(
            "Поиск по всему", "Поиск по автору",
            "Поиск по названию", "Поиск по жанру",
            "Поиск по издателю")
        binding.bookFilter.layoutManager = LinearLayoutManager(requireContext())
        binding.bookFilter.adapter = FilterResAdapter(adapter, requireContext())

        binding.backToSearch.setOnClickListener {
            presenter.navigationToSearch("word")
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

    override fun initViews() {
        initAdapters()
    }
}