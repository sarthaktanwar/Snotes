package com.example.snotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InotesRVadapter {
     private lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recylerView.layoutManager = LinearLayoutManager(this)
        val adapter =notesRVAdapter(this,this)
        recylerView.adapter =adapter

        viewModel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }

        })



    }

    override fun onItemClicked(note: Note) {
        TODO("Not yet implemented")
        viewModel.deleteNote(note)
        Toast.makeText(this," ${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val noteText =input.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNote(Note(noteText))
            Toast.makeText(this," $ noteText Deleted",Toast.LENGTH_LONG).show()
        }
    }
}