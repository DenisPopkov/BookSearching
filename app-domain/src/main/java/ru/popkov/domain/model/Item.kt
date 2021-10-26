package ru.popkov.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Item(
    @SerializedName("volumeInfo")
    @Expose
    val volumeInfo: VolumeInfo? = null
): Parcelable