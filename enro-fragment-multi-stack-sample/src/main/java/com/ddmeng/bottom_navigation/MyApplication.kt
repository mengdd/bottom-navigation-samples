package com.ddmeng.bottom_navigation

import android.app.Application
import dev.enro.annotations.NavigationComponent
import dev.enro.core.controller.NavigationApplication
import dev.enro.core.controller.NavigationController
import dev.enro.core.controller.navigationController

@NavigationComponent
class MyApplication : Application(), NavigationApplication {
    override val navigationController: NavigationController = navigationController {}
}