package ru.popkov.ui.common.mvp.base

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject

abstract class BaseActivity : MvpAppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()

    protected abstract var navigator: AppNavigator

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}