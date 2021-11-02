package ru.popkov.ui.model

import androidx.annotation.StringRes
import ru.popkov.ui.R

enum class Filters(@StringRes val res: Int) {
    ALL(R.string.all_search),
    AUTHOR(R.string.by_author),
    TITLE(R.string.by_title),
    GENRE(R.string.by_genre),
    PUBLISHER(R.string.by_publisher)
}
