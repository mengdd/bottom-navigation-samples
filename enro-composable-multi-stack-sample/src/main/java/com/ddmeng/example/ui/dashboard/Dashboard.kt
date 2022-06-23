package com.ddmeng.example.ui.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ddmeng.example.DashboardKey
import com.ddmeng.example.DetailKey
import dev.enro.annotations.ExperimentalComposableDestination
import dev.enro.annotations.NavigationDestination
import dev.enro.core.compose.navigationHandle
import dev.enro.core.forward
import java.util.*

@Composable
@ExperimentalComposableDestination
@NavigationDestination(DashboardKey::class)
fun DashboardScreen() {
    val viewModel: DashboardViewModel = viewModel()
    val text = viewModel.text.observeAsState()
    val navigation = navigationHandle()
    Text(text = text.value ?: "",
        modifier = Modifier.clickable {
            navigation.forward(DetailKey(id = UUID.randomUUID().toString()))
        }
    )
}