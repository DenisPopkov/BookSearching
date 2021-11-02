package ru.popkov.ui.common.views.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import ru.popkov.ui.common.ext.indexOfOrNull

open class SimpleAdapter<T, VB : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    private val createViewHolder: (VB) -> SimpleViewHolder<T>,
    private val onClickCallback: ((T, pos: Int) -> Unit)? = null
) : RecyclerView.Adapter<SimpleViewHolder<T>>() {

    val items: MutableList<T> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun swapItems(newItems: List<T>) {
        if (newItems == items) return
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder<T> {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)
        return createViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder<T>, position: Int) {
        val item = items[position]
        holder.bindTo(item, position, onClickCallback)
    }
}