package ru.popkov.ui.screens.search.viewholder

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import ru.popkov.domain.model.Item
import ru.popkov.ui.R
import ru.popkov.ui.databinding.BookItemBinding

class SearchViewHolder(private val binding: BookItemBinding, private val context: Context) :
    SimpleViewHolder<Item>(binding.root) {

    override fun bindTo(
        item: Item,
        pos: Int,
        onClickCallback: ((Item, Int) -> Unit)?
    ) {

        with(binding) {
            var imgUrl = item.volumeInfo?.imageLinks?.smallThumbnail.toString()
            imgUrl = imgUrl.replace("http", "https")
            Glide.with(context)
                .load(imgUrl)
                .placeholder(R.drawable.book_placeholder)
                .centerCrop()
                .into(bookImage)
            bookTitle.text = item.volumeInfo?.title
            author.text = item.volumeInfo?.authors?.first()
        }
    }
}