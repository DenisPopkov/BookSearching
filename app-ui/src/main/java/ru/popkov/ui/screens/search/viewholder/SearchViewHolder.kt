package ru.popkov.ui.screens.search.viewholder

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import ru.popkov.domain.model.Item
import ru.popkov.ui.databinding.BookItemBinding

class SearchViewHolder(private val binding: BookItemBinding, private val context: Context) :
    SimpleViewHolder<List<Item>>(binding.root) {

    override fun bindTo(
        item: List<Item>,
        pos: Int,
        onClickCallback: ((List<Item>, Int) -> Unit)?
    ) {

        with(binding) {
            Glide.with(context).load(item[pos].volumeInfo?.smallThumbnail).into(bookImage)
            bookTitle.text = item[pos].volumeInfo?.title
            author.text = item[pos].volumeInfo?.authors?.first()
        }
    }
}