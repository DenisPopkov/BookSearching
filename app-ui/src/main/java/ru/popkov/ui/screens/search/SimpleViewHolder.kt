package ru.popkov.ui.screens.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleViewHolder<T>(containerView: View) : RecyclerView.ViewHolder(containerView) {

    abstract fun bindTo(item: T, pos: Int, onClickCallback: ((T, Int) -> Unit)? = null)
}