package ru.nickolay.bored.presentation.feature

import ru.nickolay.bored.R


sealed class NavigationItems(
    val titleResId: Int,
    val image: Int
) {
    object Home: NavigationItems(R.string.home, R.drawable.ic_home)
    object Favorite: NavigationItems(R.string.favorite, R.drawable.ic_favorite)
    object Settings: NavigationItems(R.string.settings, R.drawable.ic_settings)
}