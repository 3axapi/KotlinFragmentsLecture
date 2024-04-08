package com.example.lectionfragments.viewmodel

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val selectedMessage = MutableLiveData<String>()

    fun setMessage(msg: String) {
        selectedMessage.value = msg
        Log.i("Viewmodel", "${selectedMessage.value}")
    }

    fun getMessage() : LiveData<String> {
        return selectedMessage
    }
}