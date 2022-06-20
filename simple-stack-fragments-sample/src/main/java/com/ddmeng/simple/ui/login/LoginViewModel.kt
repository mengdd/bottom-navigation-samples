package com.ddmeng.simple.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel() : ViewModel() {
    init {
        Log.i("fragments", "LoginViewModel${this.hashCode()} init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("fragments", "LoginViewModel${this.hashCode()} onCleared")
    }
}