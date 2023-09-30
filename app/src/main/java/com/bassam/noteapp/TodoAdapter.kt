package com.bassam.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bassam.noteapp.model.NoteModel

class TodoAdapter(private var datalist: ArrayList<NoteModel>):RecyclerView.Adapter<TodoAdapter.Todoviewholder>() {
    class Todoviewholder(item:View):RecyclerView.ViewHolder(item) {
        val title=item.findViewById<TextView>(R.id.sampleTitle)
        val desc=item.findViewById<TextView>(R.id.sampleDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Todoviewholder {
        val item=LayoutInflater.from(parent.context).inflate(R.layout.sample_layout,parent,false)
        return Todoviewholder(item)
    }

    override fun onBindViewHolder(holder: Todoviewholder, position: Int) {
        holder.title.text=datalist[position].title
        holder.desc.text=datalist[position].description
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}