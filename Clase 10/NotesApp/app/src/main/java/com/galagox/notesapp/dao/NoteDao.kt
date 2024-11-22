package com.galagox.notesapp.dao

import androidx.room.*
import com.galagox.notesapp.models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): kotlinx.coroutines.flow.Flow<List<Note>>
}