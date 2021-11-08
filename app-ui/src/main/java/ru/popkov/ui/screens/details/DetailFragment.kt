package ru.popkov.ui.screens.details

import android.widget.Toast
import com.bumptech.glide.Glide
import moxy.presenter.InjectPresenter
import ru.popkov.domain.model.Item
import ru.popkov.ui.common.mvp.base.BaseFragment
import ru.popkov.ui.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate),
    DetailView {

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    override fun initViews() {
        setListeners()
        presenter.getData()
    }

    private fun setListeners() {
        binding.backToSearchScreen.setOnClickListener {
            presenter.navigateToSearch()
        }
    }

    override fun showBook(item: List<Item>) {
        Toast.makeText(requireContext(), item.first().volumeInfo?.title + " Thats", Toast.LENGTH_SHORT).show()
        Glide.with(requireContext())
            .load(item.first().volumeInfo?.imageLinks).into(binding.detailBookImage)
        binding.detailTitle.text = item.first().volumeInfo?.title
        binding.detailAuthorName.text = item.first().volumeInfo?.authors?.first()
        binding.detailDescription.text = item.first().volumeInfo?.description
    }
}