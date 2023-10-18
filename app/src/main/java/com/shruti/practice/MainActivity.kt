package com.shruti.practice

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.shruti.practice.databinding.ActivityMainBinding
import com.shruti.practice.databinding.CustomDialogBinding
import com.shruti.practice.RecyclerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecyclerAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var item : ArrayList<Notesdataclass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btalert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Welcome to Alert Dialog ")
                .setMessage("Alert dialog have its own builder")
                .setPositiveButton("Yes") {_,_ ->
                    Toast.makeText(this, "Yes , it has own builder", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){_,_->
                    Toast.makeText(this,"No , it has no builder",Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Don't know"){_,_ ->
                    Toast.makeText(this,"User donot have any idea",Toast.LENGTH_SHORT).show()
                }.show()
        }
        binding.btncustom.setOnClickListener {
            var dialog = Dialog(this)
            var dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.btnsave.setOnClickListener {
                if (dialogBinding.etname.text.isNullOrEmpty()){
                    dialogBinding.etname.error = " Enter name"
                }
                else{
                    Toast.makeText(this,"Name saved succesfully",Toast.LENGTH_SHORT).show()
                }
            }
            dialog.show()
        }
        binding.btncrud.setOnClickListener {
            var intent = Intent(this, CrudActivity::class.java)
            startActivity(intent)
        }
        binding.btnpopup.setOnClickListener {
            var intent = Intent(this,PopUpmenu::class.java)
            startActivity(intent)
        }
        binding.btnoptionmenu.setOnClickListener {
            var intent = Intent(this,OptionMenubar::class.java)
            startActivity(intent)
        }
        binding.btnwebview.setOnClickListener {
            var intent = Intent(this,Webview::class.java)
            startActivity(intent)
        }

    }

}