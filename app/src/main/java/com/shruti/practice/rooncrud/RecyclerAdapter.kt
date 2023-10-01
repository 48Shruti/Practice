package com.shruti.practice.rooncrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.shruti.practice.R

class RecyclerAdapter (var item : ArrayList<Notesdataclass>, var notesInterface: NotesInterface): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.tvtitle)
        var descriptrion = view.findViewById<TextView>(R.id.tvdescription)
        var time = view.findViewById<TextView>(R.id.tvtime)
        var id = view.findViewById<TextView>(R.id.tvid)
        var update = view.findViewById<ImageView>(R.id.imgupdate)
        var delete = view.findViewById<ImageView>(R.id.imgdelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.notes_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
         return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(item[position].title)
        holder.descriptrion.setText(item[position].description)
        holder.time.setText(item[position].time)
        holder.id.setText(item[position].id.toString())
        holder.update.setOnClickListener {
            notesInterface.updateNotes(item[position],position)
        }
        holder.delete.setOnClickListener {
            notesInterface.deleteNotes(item[position],position)
        }
    }
}