package com.example.roomdbexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler(private val notes: List<NoteBookData>,private val context: Context): RecyclerView.Adapter<AdapterRecycler.MainViewHolder>() {

    class MainViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
        val bookTitle: TextView =itemView.findViewById(R.id.titleText)
        //val bookSubject: TextView =itemView.findViewById(R.id.subjectText)
        val bookDescription: TextView =itemView.findViewById(R.id.descriptionText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bookTitle.text = notes[position].title
       // holder.bookSubject.text = notes[position].subject
        holder.bookDescription.text = notes[position].description
    }

    override fun getItemCount(): Int {
       return notes.size
    }
}