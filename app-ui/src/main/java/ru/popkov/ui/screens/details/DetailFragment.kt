package ru.popkov.ui.screens.details

import moxy.presenter.InjectPresenter
import ru.popkov.domain.model.Item
import ru.popkov.ui.R
import ru.popkov.ui.common.ext.toHttps
import ru.popkov.ui.common.ext.uploadImage
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.databinding.FragmentDetailBinding

class DetailFragment(
    private val detailBookItem: Item,
) : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate), DetailView {

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    override fun initViews() {
        setListeners()
        setUpDetailBookInformation()
    }

    private fun setListeners() {
        binding.backToSearchScreen.setOnClickListener {
            presenter.navigateToSearch()
        }
    }

    private fun setUpDetailBookInformation() {
        val book = detailBookItem.volumeInfo
        val detailBookImageUrl = book?.imageLinks?.thumbnail?.toHttps().toString()
        with(binding) {
            detailBookImage.uploadImage(detailBookImageUrl, R.drawable.book_placeholder)
            detailTitle.text = book?.title
            detailAuthorName.text = book?.authors?.first()
            detailDescription.text = book?.description
        }
    }
}