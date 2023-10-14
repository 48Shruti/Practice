package com.shruti.practice

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shruti.practice.databinding.ActivityCrudBinding
import com.shruti.practice.databinding.CustomNotesBinding
import com.shruti.practice.RecyclerAdapter

class CrudActivity : AppCompatActivity(), NotesInterface {
    lateinit var binding: ActivityCrudBinding
    lateinit var adapter: RecyclerAdapter
    lateinit var layoutManager: LinearLayoutManager
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
        binding.fab.setOnClickListener {
            var dialog = Dialog(this)
            var dialogBinding = CustomNotesBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.title = "Title"
            dialogBinding.description = "Description"
            dialogBinding.btnsave.setOnClickListener{
            if (dialogBinding.ettitle.text.toString().isNullOrEmpty()) {
                dialogBinding.ettitle.error = "Enter title"
            } else if (dialogBinding.etdescription.text.toString().isNullOrEmpty()) {
                dialogBinding.etdescription.error = "Enter description"
            } else {
                    item.add(
                        Notesdataclass(
                            title = dialogBinding.ettitle.text.toString(),
                            description = dialogBinding.etdescription.text.toString()
                        )
                    )
                dialog.dismiss()
                adapter.notifyDataSetChanged()
                }

            }
            dialog.show()
        }
    }

    override fun updateNotes(notesdataclass: Notesdataclass, position: Int) {
        var dialog = Dialog(this)
        var dialogBinding = CustomNotesBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.title = "Title"
        dialogBinding.description = "Description"
        if (dialogBinding.ettitle.text.toString().isNullOrEmpty()) {
            dialogBinding.ettitle.error = "Enter title"
        } else if (dialogBinding.etdescription.text.toString().isNullOrEmpty()) {
            dialogBinding.etdescription.error = "Enter description"
        } else {
            item.set(
                position,
                Notesdataclass(
                    title = dialogBinding.title.toString(),
                    description = dialogBinding.description.toString()
                )
            )
        }
        dialog.show()
        adapter.notifyDataSetChanged()
    }


    override fun deleteNotes(notesdataclass: Notesdataclass, position: Int) {
        item.removeAt(position)
        adapter.notifyDataSetChanged()
    }

}
