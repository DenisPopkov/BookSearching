package ru.popkov.ui.screens.search.viewholder

import android.content.Context
import com.bumptech.glide.Glide
import ru.popkov.domain.model.Item
import ru.popkov.ui.R
import ru.popkov.ui.common.ext.toHttps
import ru.popkov.ui.common.views.recycler.SimpleViewHolder
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.navigation.Screens

class SearchViewHolder(private val binding: BookItemBinding, private val context: Context) :
    SimpleViewHolder<Item>(binding.root) {

    override fun bindTo(
        item: Item,
        pos: Int,
        onClickCallback: ((Item, Int) -> Unit)?
    ) {

        with(binding) {
            val imgUrl = item.volumeInfo?.imageLinks?.smallThumbnail?.toHttps()
            Glide.with(context)
                .load(imgUrl)
                .placeholder(R.drawable.book_placeholder)
                .centerCrop()
                .into(bookImage)
            bookTitle.text = item.volumeInfo?.title
            author.text = item.volumeInfo?.authors?.first()

            bookImage.setOnClickListener {
                onClickCallback?.invoke(item, pos)
            }
        }
    }
}