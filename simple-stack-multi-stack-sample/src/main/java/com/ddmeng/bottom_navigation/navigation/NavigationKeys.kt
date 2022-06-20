package com.ddmeng.bottom_navigation.navigation

import androidx.fragment.app.Fragment
import com.ddmeng.bottom_navigation.ui.dashboard.DashboardFragment
import com.ddmeng.bottom_navigation.ui.detail.DetailFragment
import com.ddmeng.bottom_navigation.ui.home.HomeFragment
import com.ddmeng.bottom_navigation.ui.notifications.NotificationsFragment
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import kotlinx.parcelize.Parcelize

@Parcelize
class First1Screen : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = HomeFragment()
}

@Parcelize
class DetailScreen : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = DetailFragment()
}

@Parcelize
class SecondScreen : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = DashboardFragment()
}

@Parcelize
class ThirdScreen : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = NotificationsFragment()
}