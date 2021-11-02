package ru.popkov.ui.common.ext

fun <T> List<T>.indexOfOrNull(element: T): Int? {
    val index = indexOf(element)
    return if (index == -1) null else index
}

fun <T> List<T>.findIndex(predicate: (T) -> Boolean): Int? {
    forEachIndexed { index, t -> if (predicate(t)) return index }
    return null
}
