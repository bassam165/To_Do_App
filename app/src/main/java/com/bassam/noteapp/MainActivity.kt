package com.bassam.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Database
import com.bassam.noteapp.database.database
import com.bassam.noteapp.database.database.Companion.initDatabase
import com.bassam.noteapp.databinding.ActivityMainBinding
import com.bassam.noteapp.model.NoteModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appDB:database
    private lateinit var amaderList:ArrayList<NoteModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDB=database.initDatabase(this)
        getLocalData()

        binding.favbtn.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }
    private fun getLocalData(){
        amaderList= arrayListOf()
        GlobalScope.launch {
            appDB.notedao().getAllNotes().forEach {
                    singledata-> amaderList.add(singledata)
            }
        }
        initRecyclerview()
    }
    private fun initRecyclerview(){
        binding.myrecycler.layoutManager=LinearLayoutManager(this)
        binding.myrecycler.adapter=TodoAdapter(amaderList)
    }
}