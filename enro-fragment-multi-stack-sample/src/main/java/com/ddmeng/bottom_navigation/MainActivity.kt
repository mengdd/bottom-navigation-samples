package com.ddmeng.bottom_navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ddmeng.bottom_navigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.enro.annotations.NavigationDestination
import dev.enro.core.*
import dev.enro.multistack.multistackController

@NavigationDestination(MainKey::class)
class MainActivity : AppCompatActivity() {

    private val navigation by navigationHandle<MainKey> {
        container(R.id.redFrame)
        container(R.id.greenFrame)
        container(R.id.blueFrame)
    }
    private val multistack by multistackController {
        container(R.id.redFrame, HomeKey())
        container(R.id.greenFrame, DashboardKey())
        container(R.id.blueFrame, NotificationsKey())
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> multistack.openStack(R.id.redFrame)
                R.id.dashboard -> multistack.openStack(R.id.greenFrame)
                R.id.notifications -> multistack.openStack(R.id.blueFrame)
            }
            true
        }
        navView.setOnItemReselectedListener {
            val key = when (it.itemId) {
                R.id.home -> HomeKey()
                R.id.dashboard -> DashboardKey()
                R.id.notifications -> NotificationsKey()
                else -> {
                    HomeKey()
                }
            }
            resetCurrentTab(key)
        }
        multistack.activeContainer.observe(this) { activeContainerId ->
            when (activeContainerId) {
                R.id.redFrame -> navView.selectedItemId = R.id.home
                R.id.greenFrame -> navView.selectedItemId = R.id.greenFrame
                R.id.blueFrame -> navView.selectedItemId = R.id.notifications
            }
        }
    }

    private fun resetCurrentTab(currentKey: NavigationKey) {
        val fragment =
            supportFragmentManager.findFragmentById(multistack.activeContainer.value!!)
        val navigationHandle = fragment?.getNavigationHandle()


        // FIXME
//        navigationHandle?.replaceRoot(currentKey)  // Will open SingleFragmentActivity
        navigationHandle?.replace(currentKey)  // Will only replace one element
    }

    fun pushToCurrentTab(key: NavigationKey) {
        val fragment =
            supportFragmentManager.findFragmentById(multistack.activeContainer.value!!)
        fragment?.getNavigationHandle()?.forward(key)
    }
}