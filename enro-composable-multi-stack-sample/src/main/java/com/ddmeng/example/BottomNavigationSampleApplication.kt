package com.ddmeng.example

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.enro.annotations.NavigationComponent
import dev.enro.core.controller.NavigationApplication
import dev.enro.core.controller.navigationController

@HiltAndroidApp
@NavigationComponent
class BottomNavigationSampleApplication : Application(), NavigationApplication {
    override val navigationController = navigationController()
}