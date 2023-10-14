package com.shruti.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.shruti.practice.databinding.ActivityOptionMenubarBinding

class OptionMenubar : AppCompatActivity() {
    lateinit var binding : ActivityOptionMenubarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionMenubarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.popupmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.firstmenu -> Toast.makeText(this,"First",Toast.LENGTH_SHORT).show()
            R.id.secondmenu -> Toast.makeText(this,"Second",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}