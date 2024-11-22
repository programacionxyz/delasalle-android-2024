package com.galagox.notesapp.repositories

import com.galagox.notesapp.dao.NoteDao
import com.galagox.notesapp.models.Note

class NoteRepository(private val noteDao:NoteDao) {
    val allNotes = noteDao.getAllNotes()
    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }
}