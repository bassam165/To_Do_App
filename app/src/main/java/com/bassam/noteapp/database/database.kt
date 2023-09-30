package com.bassam.noteapp.database

import android.content.Context
import android.content.Entity
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bassam.noteapp.dao.NoteDao
import com.bassam.noteapp.model.NoteModel
import java.security.AccessControlContext

@Database(entities = [NoteModel::class], version = 1)
abstract class database:RoomDatabase() {
    abstract fun notedao():NoteDao

    companion object{
        var INSTANCES: database?=null
        fun initDatabase(context: Context):database{
            var instance=Room.databaseBuilder(
                context.applicationContext,
                database::class.java,
                "app_database"
            ).build()
            INSTANCES=instance
            return instance
        }
    }

}