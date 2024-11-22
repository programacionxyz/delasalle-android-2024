package com.galagox.notesapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
// import androidx.compose.foundation.lazy.LazyColumn
// import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.galagox.notesapp.models.Note
import com.galagox.notesapp.ui.viewmodel.NoteViewModel

@Composable
fun NoteApp(innerPadding: PaddingValues, noteViewModel: NoteViewModel = viewModel()) {

    val notes by noteViewModel.allNote.collectAsState(initial = emptyList())
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            noteViewModel.insert(Note(title = title, description = description))
            title = ""
            description = ""
        }) {
            Text("Add Note")
        }
        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(notes) { note ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), onClick = {
                    noteViewModel.delete(note)
                }) {
                    Column {
                        Text(text = note.title)
                        Spacer(Modifier.height(4.dp))
                        Text(text = note.description)
                    }
                }
            }
        }


    }
}
