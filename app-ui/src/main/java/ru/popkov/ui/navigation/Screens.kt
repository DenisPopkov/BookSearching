package ru.popkov.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.popkov.domain.model.BookResponse
import ru.popkov.domain.model.Item
import ru.popkov.ui.screens.details.DetailFragment
import ru.popkov.ui.screens.filter.FilterFragment
import ru.popkov.ui.screens.search.SearchFragment

@Suppress("FunctionName")
object Screens {

    fun Filter() = FragmentScreen { FilterFragment() }
    fun Search() = FragmentScreen { SearchFragment() }
    fun Detail() = FragmentScreen { DetailFragment() }
}