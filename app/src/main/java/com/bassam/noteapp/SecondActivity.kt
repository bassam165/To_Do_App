package com.bassam.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import com.bassam.noteapp.database.database
import com.bassam.noteapp.databinding.ActivitySecondBinding
import com.bassam.noteapp.model.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.zip.Inflater

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    private lateinit var appDB:database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDB=database.initDatabase(this)
        binding.savebtn.setOnClickListener {
            val title=binding.titleET.text.toString()
            val desc=binding.descET.text.toString()
            val myobj=NoteModel(null,title,desc)
            GlobalScope.launch {
                appDB.notedao().insert(myobj)
            }
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}