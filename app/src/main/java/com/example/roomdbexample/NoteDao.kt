package com.example.roomdbexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("Select * From noteBook")
    fun getAllNotes() : List<NoteBookData>

    @Insert
    fun  insertAll(vararg note: NoteBookData)
}