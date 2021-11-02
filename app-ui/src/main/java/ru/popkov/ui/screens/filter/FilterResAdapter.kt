package ru.popkov.ui.screens.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parameter_item.view.*
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R
import ru.popkov.ui.model.FilterModel

class FilterResAdapter(
    private val parameters: MutableList<FilterModel>,
    private val filters: IPreference): RecyclerView.Adapter<FilterViewHolder>() {

    private var rawIndex = 0
    private var initRecyclerMarks = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.parameter_item, parent, false))

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {

        if (initRecyclerMarks) {
            rawIndex = parameters[position].filterCheck
            initRecyclerMarks = false
        }

        val filter = parameters[position].parameter
        holder.itemView.filterItemName.text = filter
        holder.itemView.filterItemCheck.isInvisible = rawIndex != position

        holder.itemView.parameter_container.setOnClickListener {
            rawIndex = position
            holder.itemView.filterItemCheck.isInvisible = rawIndex != position
            notifyDataSetChanged()
            filters.createPreferencesFile(filter)
        }

        holder.itemView.filterItemCheck.isInvisible = rawIndex != position
    }

    override fun getItemCount() = parameters.size
}

class FilterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)