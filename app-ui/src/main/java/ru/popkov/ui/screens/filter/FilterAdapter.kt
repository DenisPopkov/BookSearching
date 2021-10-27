package ru.popkov.ui.screens.filter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_item.view.*
import kotlinx.android.synthetic.main.fragment_filter.view.*
import kotlinx.android.synthetic.main.parameter_item.view.*
import ru.popkov.ui.R
import ru.popkov.ui.common.storage.createPreferencesFile
import ru.popkov.ui.common.storage.getFilterParameter
import ru.popkov.ui.databinding.FragmentFilterBinding
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.navigation.Screens
import ru.popkov.ui.screens.search.viewholder.SimpleViewHolder

class FilterResAdapter(
    private val parameters: ArrayList<String>,
    private val context: Context): RecyclerView.Adapter<FilterViewHolder>() {

    var rawIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.parameter_item, parent, false))

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.itemView.param.text = parameters[position]

        holder.itemView.parameter_container.setOnClickListener {
            rawIndex = position
            notifyDataSetChanged()

            val filter = when(position) {
                0 -> parameters[position]
                1 -> parameters[position]
                2 -> parameters[position]
                3 -> parameters[position]
                4 -> parameters[position]
                else -> "default"
            }

            createPreferencesFile(context, "default")
            createPreferencesFile(context, filter)
        }

        if (rawIndex == position) {
            holder.itemView.check_icon.visibility = View.VISIBLE
        } else {
            holder.itemView.check_icon.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount() = parameters.size
}

class FilterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)