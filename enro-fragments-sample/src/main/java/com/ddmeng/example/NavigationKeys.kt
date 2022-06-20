package com.ddmeng.example

import dev.enro.core.NavigationKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainKey(val name: String = "") : NavigationKey

@Parcelize
data class FragmentAKey(val name: String, val age: Int) : NavigationKey
