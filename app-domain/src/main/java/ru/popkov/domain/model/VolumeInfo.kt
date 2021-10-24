package ru.popkov.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class VolumeInfo(
    val authors: List<String>,
    val description: String,
    val imageLinks: ImageLinks,
    val title: String
)