package com.ddmeng.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.enro.annotations.NavigationDestination
import dev.enro.core.forward
import dev.enro.core.navigationHandle

@NavigationDestination(MainKey::class)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val navigation by navigationHandle<MainKey> {
        defaultKey(
            MainKey()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        navigation.forward(FragmentAKey(name = "start", age = 18))
    }
}

