package com.shruti.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import com.shruti.practice.databinding.ActivityPopUpmenuBinding

class PopUpmenu : AppCompatActivity() {
    var binding : ActivityPopUpmenuBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopUpmenuBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnpopup?.setOnClickListener {
        PopupMenu(this,binding?.btnpopup).apply {
            menuInflater.inflate(R.menu.popupmenu,menu)
            setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.firstmenu -> Toast.makeText(this@PopUpmenu,"First",Toast.LENGTH_SHORT).show()
                    R.id.secondmenu -> Toast.makeText(this@PopUpmenu,"Second",Toast.LENGTH_SHORT).show()
                }
                return@setOnMenuItemClickListener true
            }
        }.show()
        }
    }
}