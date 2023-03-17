package com.example.noteapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.Models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("UPDATE notes_table SET title = :title, note = :note WHERE id = :id")
    suspend fun updateNote(id: Int?, title: String?, note: String?)

    @Delete
    suspend fun delete(note: Note)
}