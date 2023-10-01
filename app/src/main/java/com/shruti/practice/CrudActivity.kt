package com.shruti.practice

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shruti.practice.databinding.ActivityCrudBinding
import com.shruti.practice.databinding.CustomDialogBinding
import com.shruti.practice.databinding.CustomNotesBinding
import com.shruti.practice.rooncrud.NotesInterface
import com.shruti.practice.rooncrud.Notesdataclass
import com.shruti.practice.rooncrud.RecyclerAdapter

class CrudActivity : AppCompatActivity(), NotesInterface {
    lateinit var binding: ActivityCrudBinding
    lateinit var adapter: RecyclerAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var dialogBinding : CustomNotesBinding
    lateinit var dialog: Dialog
     var item = arrayListOf<Notesdataclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerlist = "Recycler List "
        binding.crudActivity = this
        layoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = layoutManager
        adapter = RecyclerAdapter(item, this)
        binding.recycler.adapter = adapter
    }
        fun fabButton(){
            var dialog = Dialog(this)
            var dialogBinding = CustomNotesBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.title = "Title"
            dialogBinding.description ="Description"
            dialogBinding.save = "Save"
            dialog.show()
        }
        fun savenotes(){
            item.add(Notesdataclass(title = dialogBinding.title.toString(), description = dialogBinding.description.toString()))

        }


    override fun updateNotes(notesdataclass: Notesdataclass, position: Int) {

    }

    override fun deleteNotes(notesdataclass: Notesdataclass, position: Int) {

    }

}