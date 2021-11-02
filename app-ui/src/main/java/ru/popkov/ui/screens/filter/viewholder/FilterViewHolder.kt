package ru.popkov.ui.screens.filter.viewholder

import androidx.core.view.isInvisible
import ru.popkov.ui.common.views.recycler.SimpleViewHolder
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.model.FilterModel

class FilterViewHolder(
    private val binding: ParameterItemBinding
) :
    SimpleViewHolder<FilterModel>(binding.root) {

    override fun bindTo(
        item: FilterModel,
        pos: Int,
        onClickCallback: ((FilterModel, Int) -> Unit)?
    ) {
        with(binding) {
            val context = filterItemName.context
            filterItemName.text = context.getString(item.parameter.res)

            parameterContainer.setOnClickListener {
                onClickCallback?.invoke(item, pos)
            }

            filterItemCheck.isInvisible = item.filterCheck.not()
        }
    }
}
