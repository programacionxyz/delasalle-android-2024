package com.galagox.notesapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galagox.notesapp.models.Note
import com.galagox.notesapp.repositories.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    val allNote = repository.allNotes
    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }
    fun delete(note:Note) = viewModelScope.launch {
        repository.delete(note)
    }
}
