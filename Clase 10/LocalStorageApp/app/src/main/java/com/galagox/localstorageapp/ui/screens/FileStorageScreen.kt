package com.galagox.localstorageapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.galagox.localstorageapp.ui.viewmodels.FileStorageViewModel

@Composable
fun FileStorageScreen( innerPaddingValues: PaddingValues, viewModel: FileStorageViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = { },
            label = { Text("Texto para guardar") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar en archivo")
        }
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Leer desde archivo")
        }
        Text(
            text = "Contenido del archivo",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
