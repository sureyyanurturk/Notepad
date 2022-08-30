package com.example.roomdbexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteBookData::class],version = 2)
abstract class AppDatabase : RoomDatabase(){
        abstract fun notedao(): NoteDao


}
