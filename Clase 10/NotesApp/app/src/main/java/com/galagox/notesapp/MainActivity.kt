package com.galagox.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.galagox.notesapp.datasources.NoteDatabase
import com.galagox.notesapp.repositories.NoteRepository
import com.galagox.notesapp.ui.navigation.TopBar
import com.galagox.notesapp.ui.screens.NoteApp
import com.galagox.notesapp.ui.theme.NotesAppTheme
import com.galagox.notesapp.ui.viewmodel.NoteViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = databaseBuilder(applicationContext,
            NoteDatabase::class.java,
            "note_database").build()
        val repository = NoteRepository(db.noteDao())

        setContent {
            Scaffold(
                topBar = { TopBar("App de notas") },
            ) { innerPadding ->
                NoteApp(innerPadding, noteViewModel = NoteViewModel(repository))
            }
        }
    }
}
