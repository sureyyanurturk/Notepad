package com.example.roomdbexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room

class CreateNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        val signBtn: Button = findViewById(R.id.signBtn)
        val titleEdit: EditText = findViewById(R.id.titleEdit)
        //val subjectEdit: EditText = findViewById(R.id.subjectEdit)
        val descriptionEdit: EditText = findViewById(R.id.descriptionEdit)

        val db:AppDatabase= Room.databaseBuilder(applicationContext,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        signBtn.setOnClickListener {
            val note = NoteBookData(titleEdit.text.toString(),descriptionEdit.text.toString())
            db.notedao().insertAll(note)
            startActivity(Intent(this@CreateNote,MainActivity::class.java))
            finish()
        }

    }
}