package ru.popkov.ui.screens.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import ru.popkov.ui.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}