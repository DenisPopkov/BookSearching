package ru.popkov.data.storage

import android.content.SharedPreferences
import ru.popkov.data.storage.base.BasePreferences

class FilterPreferences(preferences: SharedPreferences):
    BasePreferences(preferences, "filter")