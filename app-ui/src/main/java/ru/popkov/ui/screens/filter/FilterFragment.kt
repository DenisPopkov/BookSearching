package ru.popkov.ui.screens.filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import ru.popkov.ui.R
import ru.popkov.ui.databinding.ActivityMainBinding.inflate
import ru.popkov.ui.databinding.FragmentFilterBinding

class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFilterBinding.inflate(inflater, container, false)

        val adapter = FilterAdapter(arrayListOf(
                "Поиск по всему", "Поиск по автору",
                "Поиск по названию", "Поиск по жанру",
                "Поиск по издателю"))
        binding.bookFilter.adapter = adapter

        return binding.root
    }
}