package com.example.snotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class notesRVAdapter(private val context:Context, private val listener:InotesRVadapter ): RecyclerView.Adapter<notesRVAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Note>()
    inner class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
         val textView = itemView.findViewById<TextView>(R.id.text)
        var deleteButton = itemView.findViewById<ImageView>(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        TODO("Not yet implemented")
        val viewHolder = NoteViewHolder( LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener{
        listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        TODO("Not yet implemented")
        val currentNote = allNotes[position]
        holder.textView.text =currentNote.text
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return allNotes.size
    }
    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}
interface InotesRVadapter{
    fun onItemClicked(note:Note)
}