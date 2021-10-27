package ru.popkov.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class VolumeInfo(
    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("authors")
    @Expose
    val authors: List<String>? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("imageLinks")
    @Expose
    val imageLinks: ImageLinks? = null
): Parcelable