package ru.popkov.ui.screens.filter.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parameter_item.view.*
import ru.popkov.domain.model.Item
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.R
import ru.popkov.ui.common.views.recycler.SimpleViewHolder
import ru.popkov.ui.databinding.BookItemBinding
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.model.FilterModel

//class FilterResAdapter(
//    private val parameters: MutableList<FilterModel>,
//    private val filters: IPreference): RecyclerView.Adapter<FilterViewHolder>() {
//
//    private var rawIndex = 0
//    private var initRecyclerMarks = true
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.parameter_item, parent, false))
//
//    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
//
//        if (initRecyclerMarks) {
//            rawIndex = parameters[position].filterCheck
//            initRecyclerMarks = false
//        }
//
//        val filter = parameters[position].parameter
//        holder.itemView.filterItemName.text = filter
//        holder.itemView.filterItemCheck.isInvisible = rawIndex != position
//
//        holder.itemView.parameter_container.setOnClickListener {
//            rawIndex = position
//            holder.itemView.filterItemCheck.isInvisible = rawIndex != position
//            notifyDataSetChanged()
//            filters.createPreferencesFile(filter)
//        }
//
//        holder.itemView.filterItemCheck.isInvisible = rawIndex != position
//    }
//
//    override fun getItemCount() = parameters.size
//}

class FilterViewHolder(
    private val binding: ParameterItemBinding,
    private val filtersPreferences: IPreference
) :
    SimpleViewHolder<FilterModel>(binding.root) {

    private var rawIndex = 0

    override fun bindTo(
        item: FilterModel,
        pos: Int,
        onClickCallback: ((FilterModel, Int) -> Unit)?
    ) {

        rawIndex = item.filterCheck

        with(binding) {
            filterItemName.text = item.parameter

            parameterContainer.setOnClickListener {
                onClickCallback?.invoke(item, pos)
                rawIndex = pos
                filterItemCheck.isInvisible = rawIndex != pos
                filtersPreferences.createPreferencesFile(item.parameter)
            }

            filterItemCheck.isInvisible = rawIndex != pos
        }
    }
}