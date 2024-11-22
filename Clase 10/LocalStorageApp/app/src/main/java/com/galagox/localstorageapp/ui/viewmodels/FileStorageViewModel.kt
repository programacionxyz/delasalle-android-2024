package com.galagox.localstorageapp.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File

class FileStorageViewModel : ViewModel() {

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText

    private val _fileContent = MutableStateFlow("")
    val fileContent: StateFlow<String> = _fileContent

    fun onInputChange(newText: String) {
        _inputText.value = newText
    }

    fun writeToFile(context: Context, fileName: String) {
        viewModelScope.launch {
            val file = File(context.filesDir, fileName)
            file.writeText(_inputText.value)
        }
    }

    fun readFromFile(context: Context, filaName: String) {
        viewModelScope.launch {
            val file = File(context.filesDir, filaName)
            _fileContent.value = if (file.exists()) {
                file.readText()
            } else {
                "El archivo no existe"
            }
        }
    }

}
