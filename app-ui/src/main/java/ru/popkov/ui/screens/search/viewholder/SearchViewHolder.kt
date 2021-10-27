package ru.popkov.ui.screens.search.viewholder

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.model.Item
import ru.popkov.ui.R
import ru.popkov.ui.databinding.BookItemBinding

class SearchViewHolder(private val binding: BookItemBinding, private val context: Context) :
    SimpleViewHolder<List<Item>>(binding.root) {

    override fun bindTo(
        item: List<Item>,
        pos: Int,
        onClickCallback: ((List<Item>, Int) -> Unit)?
    ) {

        with(binding) {
            Log.d("efefe", "pos - $pos")
            Glide.with(context)
                .load(item[pos].volumeInfo?.imageLinks?.smallThumbnail)
                .placeholder(R.drawable.book_placeholder)
                .into(bookImage)
            bookTitle.text = item[pos].volumeInfo?.title
            author.text = item[pos].volumeInfo?.authors?.first()
        }
    }
}