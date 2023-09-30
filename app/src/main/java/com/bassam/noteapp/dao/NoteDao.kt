package com.bassam.noteapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bassam.noteapp.model.NoteModel

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<NoteModel>

    @Query("SELECT * FROM note_table WHERE title LIKE:amadertitle LIMIT 5")
    fun getAllNotesByTitle(amadertitle:String): List<NoteModel>

    @Delete
    fun deletNote(note: NoteModel)

    @Insert
    fun insert(note: NoteModel)
}