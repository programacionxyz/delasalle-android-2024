package com.galagox.notesapp.datasources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.galagox.notesapp.dao.NoteDao
import com.galagox.notesapp.models.Note

@Database( entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}

