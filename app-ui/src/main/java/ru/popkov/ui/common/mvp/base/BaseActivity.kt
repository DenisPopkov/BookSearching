package ru.popkov.ui.common.mvp.base

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()

    protected abstract var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setAppNavigator(appNavigator: AppNavigator) {
        navigator = appNavigator
        navigatorHolder.setNavigator(navigator)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}