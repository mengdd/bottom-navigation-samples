package com.ddmeng.bottom_navigation

import dev.enro.core.NavigationKey
import kotlinx.parcelize.Parcelize

@Parcelize
class MainKey : NavigationKey

abstract class TabKey(val title: String) : NavigationKey

@Parcelize
class HomeKey : TabKey("home")

@Parcelize
class DashboardKey : TabKey("dashboard")

@Parcelize
class NotificationsKey : TabKey("notifications")

@Parcelize
class Detail(val id: String) : NavigationKey