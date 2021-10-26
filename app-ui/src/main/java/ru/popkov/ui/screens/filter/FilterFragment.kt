package ru.popkov.ui.screens.filter

import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.common.storage.createPreferenceFilterFile
import ru.popkov.ui.common.storage.getUserFilterParameter
import ru.popkov.ui.databinding.FragmentFilterBinding

class FilterFragment : BaseFragment<FragmentFilterBinding>(FragmentFilterBinding::inflate),
FilterView{

    init {
        createPreferenceFilterFile(requireContext(), "all")
    }

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    @ProvidePresenter
    fun providePresenter(): FilterPresenter {

        return FilterPresenter()
    }

    private fun initAdapters() {
        val adapter = FilterAdapter(arrayListOf(
            "Поиск по всему", "Поиск по автору",
            "Поиск по названию", "Поиск по жанру",
            "Поиск по издателю"))
        binding.bookFilter.adapter = adapter
    }

    private fun setListeners() {
        binding.apply {
            backToSearch.setOnClickListener { presenter.navigationToSearch(getUserFilterParameter(requireContext())) }
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
        setListeners()
        initAdapters()
    }
}