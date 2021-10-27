package ru.popkov.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.popkov.ui.screens.filter.FilterFragment
import ru.popkov.ui.screens.search.SearchFragment

@Suppress("FunctionName")
object Screens {

    fun Filter() = FragmentScreen { FilterFragment() }
    fun Search(filter: String) = FragmentScreen { SearchFragment() }
}