package com.galagox.notesapp.ui.screens

import androidx.compose.foundation.layout.*
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
fun NoteApp(innerPadding:PaddingValues, noteViewModel: NoteViewModel = viewModel()) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(innerPadding)) {
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
            title = ""
            description = ""
        }) {
            Text("Add Note")
        }
        Spacer(Modifier.height(16.dp))


    }
}
