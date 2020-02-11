package com.livewire.livewire.ui.login

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.livewire.livewire.R


enum class MainScreen(@IdRes val menuItemId: Int, @DrawableRes val menuItemIconId: Int, @StringRes val titleStringId: Int, val fragment: Fragment) {
    HOME(R.id.home, R.drawable.home_icon, R.string.title_home, HomeFragment()),
    PROFILE(R.id.profile, R.drawable.profile, R.string.title_profile, ProfileFragment()),
    LOCAL(R.id.local, R.drawable.local, R.string.title_local, LocalFragment()),
    NOTIFICATIONS(R.id.notifications, R.drawable.notifications, R.string.title_notifications, NotificationsFragment()),
    SETTINGS(R.id.settings, R.drawable.settings, R.string.title_settings, SettingsFragment())
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }

    }
    return null
}