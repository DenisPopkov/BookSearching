package ru.popkov.booksearch.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

fun provideUi() = module {
    provideNavigation()
}

private fun org.koin.core.module.Module.provideNavigation() {
    val router = Cicerone.create(Router())
    single { router.getNavigatorHolder() }
    single { router.router }
}