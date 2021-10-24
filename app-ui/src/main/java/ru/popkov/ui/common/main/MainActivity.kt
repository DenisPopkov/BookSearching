package ru.popkov.ui.common.main

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.presenter.InjectPresenter
import ru.popkov.ui.R
import ru.popkov.ui.common.mvp.base.BaseActivity
import ru.popkov.ui.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), MainView {
    override var navigator: AppNavigator
        get() = AppNavigator(this, R.id.fragment_container)
        set(value) {}

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun showNoInternetAlert() {
        TODO("Not yet implemented")
    }

    override fun showServerAlert() {
        TODO("Not yet implemented")
    }

    override fun showUnknownAlert(message: String?) {
        TODO("Not yet implemented")
    }
}
