package com.rzsahu.demolivedata.viewmodel

import android.text.Editable
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rzsahu.demolivedata.model.Information

class MainViewModel : ViewModel() {

    private val initText: Information = Information("Hello, I am init text")
    private val onClickText: Information = Information("Hello, I am changed on click")

    private var information = MutableLiveData<String>(initText.message)

    private val informationLiveData: LiveData<String>
        get() = information

    fun setInformation() {
        information.value = onClickText.message
    }

    fun getInfoLiveData() : LiveData<String> = informationLiveData

    fun updateLiveData(s: Editable) {
        if (informationLiveData.value != s.toString()) {
            information.value = s.toString()
        }
    }
}