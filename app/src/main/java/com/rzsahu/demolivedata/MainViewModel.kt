package com.rzsahu.demolivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var information = MutableLiveData<String>("Hello Dear!!")

    private val informationLiveData: LiveData<String>
        get() = information

    fun setInformation(info : String) {
        information.value = info
    }

    fun getInfoLiveData() : LiveData<String> = informationLiveData
}