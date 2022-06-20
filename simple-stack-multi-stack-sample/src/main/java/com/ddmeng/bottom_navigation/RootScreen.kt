package com.ddmeng.bottom_navigation

import androidx.fragment.app.Fragment
import com.ddmeng.bottom_navigation.navigation.First1Screen
import com.ddmeng.bottom_navigation.navigation.FragmentStackHost
import com.ddmeng.bottom_navigation.navigation.SecondScreen
import com.ddmeng.bottom_navigation.navigation.ThirdScreen
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import com.zhuinden.simplestackextensions.servicesktx.add
import kotlinx.parcelize.Parcelize

@Parcelize
class RootScreen : DefaultFragmentKey(), DefaultServiceProvider.HasServices {
    companion object {
        const val FIRST_STACK = "FirstStack"
        const val SECOND_STACK = "SecondStack"
        const val THIRD_STACK = "ThirdStack"
    }

    override fun instantiateFragment(): Fragment = RootFragment()

    override fun getScopeTag(): String = javaClass.name

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            add(FragmentStackHost(First1Screen()), FIRST_STACK)
            add(FragmentStackHost(SecondScreen()), SECOND_STACK)
            add(FragmentStackHost(ThirdScreen()), THIRD_STACK)
        }
    }
}