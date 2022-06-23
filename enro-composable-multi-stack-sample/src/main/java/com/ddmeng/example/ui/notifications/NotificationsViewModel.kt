package com.ddmeng.example.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications"
    }
    val text: LiveData<String> = _text

    init {
        Log.i("viewmodel", "NotificationsViewModel init ${hashCode()}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("viewmodel", "NotificationsViewModel onClear ${hashCode()}")
    }
}