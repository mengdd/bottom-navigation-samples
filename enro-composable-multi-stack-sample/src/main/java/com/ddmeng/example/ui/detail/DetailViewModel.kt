package com.ddmeng.example.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is detail"
    }
    val text: LiveData<String> = _text

    init {
        Log.i("viewmodel", "DetailViewModel init ${hashCode()}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("viewmodel", "DetailViewModel onClear ${hashCode()}")
    }
}