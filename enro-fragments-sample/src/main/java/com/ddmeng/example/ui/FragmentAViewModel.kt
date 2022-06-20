package com.ddmeng.example.ui

import androidx.lifecycle.ViewModel
import com.ddmeng.example.FragmentAKey
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.enro.viewmodel.navigationHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FragmentAViewModel @Inject constructor() : ViewModel() {
    private val _text = MutableStateFlow("hello")
    val text: StateFlow<String> = _text
    private val navigation by navigationHandle<FragmentAKey>()

    init {
        _text.value = navigation.key.name + "\n" + navigation.key.age
    }
}
