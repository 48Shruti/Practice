package com.shruti.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.practice.databinding.ActivityWebviewBinding

class Webview : AppCompatActivity() {
    lateinit var binding : ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.web.loadUrl("https://www.davietjal.org/")
        binding.web.settings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.web.canGoBack()){
            binding.web.goBack()
        }else{
                finish()
        }
    }
}