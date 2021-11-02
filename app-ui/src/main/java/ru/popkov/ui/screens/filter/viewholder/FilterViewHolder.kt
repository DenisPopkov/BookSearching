package ru.popkov.ui.screens.filter.viewholder

import androidx.core.view.isInvisible
import ru.popkov.domain.storage.IPreference
import ru.popkov.ui.common.views.recycler.SimpleViewHolder
import ru.popkov.ui.databinding.ParameterItemBinding
import ru.popkov.ui.model.FilterModel

class FilterViewHolder(
    private val binding: ParameterItemBinding
) :
    SimpleViewHolder<FilterModel>(binding.root) {

    private var previousPosition = 0

    override fun bindTo(
        item: FilterModel,
        pos: Int,
        onClickCallback: ((FilterModel, Int) -> Unit)?
    ) {

        previousPosition = item.filterCheck

        with(binding) {
            filterItemName.text = item.parameter

            parameterContainer.setOnClickListener {
                onClickCallback?.invoke(item, pos)
                previousPosition = pos
            }

            filterItemCheck.isInvisible = previousPosition != pos
        }
    }
}