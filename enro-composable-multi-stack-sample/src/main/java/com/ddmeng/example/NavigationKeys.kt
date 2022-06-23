package com.ddmeng.example

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
data class DetailKey(val id: String) : NavigationKey