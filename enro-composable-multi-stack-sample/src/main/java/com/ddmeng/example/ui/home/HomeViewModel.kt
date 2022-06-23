package com.ddmeng.example.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home"
    }
    val text: LiveData<String> = _text

    init {
        Log.i("viewmodel", "HomeViewModel init ${hashCode()}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("viewmodel", "HomeViewModel onClear ${hashCode()}")
    }
}