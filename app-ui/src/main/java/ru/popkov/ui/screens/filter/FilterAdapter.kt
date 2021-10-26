package ru.popkov.ui.screens.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.parameter_item.view.*
import ru.popkov.ui.R

class FilterAdapter(val parameters: ArrayList<String>) : BaseAdapter() {

    override fun getCount() = parameters.size

    override fun getItem(position: Int) = parameters[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {
        val rowView = LayoutInflater.from(parent?.context).inflate(R.layout.parameter_item, parent, false)
        val parameter = getItem(position)
        if (position == 0) rowView.check_icon.visibility = View.VISIBLE
        rowView.parameter_container.setOnClickListener {
            rowView.check_icon.visibility = View.INVISIBLE
            when(position) {
                0 -> rowView.check_icon.visibility = View.VISIBLE
                1 -> rowView.check_icon.visibility = View.VISIBLE
                2 -> rowView.check_icon.visibility = View.VISIBLE
                3 -> rowView.check_icon.visibility = View.VISIBLE
                4 -> rowView.check_icon.visibility = View.VISIBLE
            }
        }
        rowView.param.text = parameter
        return rowView
    }
}