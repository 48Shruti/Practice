package com.shruti.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.practice.databinding.ActivityPopUpmenuBinding

class PopUpmenu : AppCompatActivity() {
    var binding : ActivityPopUpmenuBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopUpmenuBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }
}