package com.ddmeng.example.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard"
    }
    val text: LiveData<String> = _text


    init {
        Log.i("viewmodel", "DashboardViewModel init ${hashCode()}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("viewmodel", "DashboardViewModel onClear ${hashCode()}")
    }
}