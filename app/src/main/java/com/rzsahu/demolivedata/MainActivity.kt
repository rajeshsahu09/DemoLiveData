package com.rzsahu.demolivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private val infoTextView : TextView
        get() = findViewById(R.id.information)
    private val updateButton : Button
        get() = findViewById(R.id.update)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.getInfoLiveData().observe(this, Observer {
            infoTextView.text = it
        })

        updateButton.setOnClickListener {
            mainViewModel.setInformation("Hi! I am updated on click")
        }
    }
}