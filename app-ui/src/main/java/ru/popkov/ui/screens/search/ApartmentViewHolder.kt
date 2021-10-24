package ru.popkov.ui.screens.search

import android.content.Context
import com.bumptech.glide.Glide
import ru.popkov.domain.model.BookModel
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.FragmentSearchBinding

class ApartmentViewHolder(private val binding: BookItemBinding, private val context: Context) :
    SimpleViewHolder<BookModel>(binding.root) {

    override fun bindTo(
        item: BookModel,
        pos: Int,
        onClickCallback: ((BookModel, Int) -> Unit)?
    ) {
        with(binding) {
            Glide.with(context).load(item.volumeInfo.imageLinks.smallThumbnail).into(bookImage)
            bookTitle.text = item.volumeInfo.title
            author.text = item.volumeInfo.authors.first()
        }
    }
}