package ru.popkov.ui.screens.filter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_item.view.*
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.parameter_item.view.*
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R

class FilterResAdapter(
    private val parameters: MutableMap<String, Int>,
    private val filters: IPreference): RecyclerView.Adapter<FilterViewHolder>() {

    private var rawIndex = 0
    private var check = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.parameter_item, parent, false))

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val filtersList = arrayListOf<String>()
        var lastCheckedItem = 0
        parameters.forEach {
            filtersList.add(it.key)
            if (it.value != 0) lastCheckedItem = it.value
        }

        val filter = filtersList[position]
        holder.itemView.param.text = filter
        // Once called
        if (check == 0) {
            rawIndex = lastCheckedItem
            check++
        }

        holder.itemView.parameter_container.setOnClickListener {
            rawIndex = position
            holder.itemView.check_icon.isInvisible = rawIndex != position
            notifyDataSetChanged()
            filters.createPreferencesFile(filter)
        }

        holder.itemView.check_icon.isInvisible = rawIndex != position
    }

    override fun getItemCount() = 5
}

class FilterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)