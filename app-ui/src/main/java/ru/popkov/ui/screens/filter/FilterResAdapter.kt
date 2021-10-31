package ru.popkov.ui.screens.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parameter_item.view.*
import ru.popkov.domain.model.Item
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.model.FilterModel
import ru.popkov.ui.screens.search.viewholder.SimpleViewHolder

class FilterResAdapter(
    private val parameters: MutableList<FilterModel>,
    private val filters: IPreference): RecyclerView.Adapter<FilterViewHolder>() {

    private var rawIndex = 0
    private var check = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.parameter_item, parent, false))

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val filtersList = arrayListOf<String>()
        var lastCheckedItem = 0
        parameters.forEach {
            filtersList.add(it.parameter)
            if (it.filterCheck != 0) lastCheckedItem = it.filterCheck
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

    override fun getItemCount() = parameters.size
}

class FilterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)