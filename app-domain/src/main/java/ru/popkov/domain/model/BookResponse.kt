package ru.popkov.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
class BookResponse(
    @SerializedName("items")
    @Expose
    val items: List<Item>? = null
): Parcelable