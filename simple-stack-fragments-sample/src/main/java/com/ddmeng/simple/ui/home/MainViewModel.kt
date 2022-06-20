package com.ddmeng.simple.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Main Fragment"
    }
    val text: LiveData<String> = _text
}