package com.ddmeng.example

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.zIndex
import dagger.hilt.android.AndroidEntryPoint
import dev.enro.annotations.NavigationDestination
import dev.enro.core.NavigationInstruction
import dev.enro.core.compose.*

@AndroidEntryPoint
@NavigationDestination(MainKey::class)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { AppBar() },
                bottomBar = { BottomNav() }
            ) { scaffoldPadding ->

                val activeContainer = localComposableManager.activeContainer

                Crossfade(
                    targetState = activeContainer,
                    animationSpec = tween(225),
                    modifier = Modifier.padding(scaffoldPadding)
                ) {
                    it ?: return@Crossfade
                    val isActive = activeContainer == it
                    EnroContainer(
                        controller = it,
                        modifier = Modifier.zIndex(if (isActive) 1f else 0f)
                    )
                }

            }
        }

    }
}

@Composable
private fun BottomNav() {
    val composableManager = localComposableManager
    BottomNavigation {
        composableManager.tabContainers().forEach {
            BottomNavigationItem(
                selected = composableManager.activeContainer == it.controller,
                onClick = { composableManager.setActiveContainer(it.controller) },
                label = { Text(it.title) },
                icon = { Icon(it.icon, null) },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
private fun AppBar() {
    val activeKey =
        localComposableManager.activeContainer?.backstack?.collectAsState()?.value?.visible?.navigationKey
    TopAppBar(
        title = {
            val title = if (activeKey is TabKey) {
                activeKey.title
            } else "Enro Example"
            Text(title)
        }
    )
}

@Composable
private fun EnroComposableManager.tabContainers(): List<BottomNavOption> {
    val homeController = rememberEnroContainerController(
        initialState = listOf(NavigationInstruction.Replace(HomeKey())),
        accept = { it is HomeKey },
        emptyBehavior = EmptyBehavior.CloseParent
    )
    val dashboardController = rememberEnroContainerController(
        initialState = listOf(
            NavigationInstruction.Replace(DashboardKey())
        ),
        accept = { it is DashboardKey },
        emptyBehavior = EmptyBehavior.Action {
            setActiveContainer(homeController)
            true
        }
    )
    val notificationsController = rememberEnroContainerController(
        initialState = listOf(
            NavigationInstruction.Replace(NotificationsKey())
        ), accept = { it is NotificationsKey }, emptyBehavior = EmptyBehavior.Action {
            setActiveContainer(homeController)
            true
        }
    )

    return listOf(
        BottomNavOption("Home", Icons.Default.List, homeController),
        BottomNavOption("Dashboard", Icons.Default.AccountBox, dashboardController),
        BottomNavOption("Notifications", Icons.Default.AccountCircle, notificationsController)
    )
}

private data class BottomNavOption(
    val title: String,
    val icon: ImageVector,
    val controller: EnroContainerController
)