package com.example.roomdbexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteBook")
data class NoteBookData(

    @ColumnInfo(name="title")
    var title: String,
    //@ColumnInfo(name="subject")
  //  var subject: String,
    @ColumnInfo(name="description")
    var description: String,
    @PrimaryKey(autoGenerate = true)
    var noteId: Int=0

)
