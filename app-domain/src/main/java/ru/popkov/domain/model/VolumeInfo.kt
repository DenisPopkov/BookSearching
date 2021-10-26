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

    @SerializedName("publisher")
    @Expose
    val publisher: String? = null,

    @SerializedName("publishedDate")
    @Expose
    val publishedDate: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("smallThumbnail")
    @Expose
    val smallThumbnail: String? = null
): Parcelable