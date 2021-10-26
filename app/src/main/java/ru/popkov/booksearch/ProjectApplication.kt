package ru.popkov.booksearch

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import ru.popkov.booksearch.di.provideData
import ru.popkov.booksearch.di.provideDomain
import ru.popkov.booksearch.di.provideUi
import ru.popkov.ui.common.main.MainView

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initDI()
    }

    private fun initDI() {
        GlobalContext.startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ProjectApplication)
            val modules = listOf(
                provideUi(),
                provideData(),
                provideDomain()
            )
            modules(modules)
        }
    }
}