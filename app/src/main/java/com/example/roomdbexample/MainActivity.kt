package com.example.roomdbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val addBtn: ImageButton = findViewById(R.id.addBtn)
        val books: MutableList<String> = arrayListOf()

        val notes: List<NoteBookData>

        val db: AppDatabase=Room.databaseBuilder(this,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        notes = db.notedao().getAllNotes()
        notes.forEach {
            books.add(it.title + " -  " + it.description)
        }


        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=AdapterRecycler(notes,this@MainActivity)

        addBtn.setOnClickListener {
            val intent=Intent(this, CreateNote::class.java)
            startActivity(intent)
        }

    }
}