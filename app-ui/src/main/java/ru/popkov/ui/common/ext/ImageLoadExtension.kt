package ru.popkov.ui.common.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.uploadImage(imageUrl: String, placeHolder: Int) {
    Glide.with(this).load(imageUrl).placeholder(placeHolder).into(this)
}