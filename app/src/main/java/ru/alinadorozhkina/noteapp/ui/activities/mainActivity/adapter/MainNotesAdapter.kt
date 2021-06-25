package ru.alinadorozhkina.noteapp.ui.activities.mainActivity.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.noteapp.R
import ru.alinadorozhkina.noteapp.data.model.Note

class MainNotesAdapter: RecyclerView.Adapter<ViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notes[position])
        Log.v("Note", notes[position].title)
    }

    override fun getItemCount() = notes.size
}

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val body = itemView.findViewById<TextView>(R.id.body)

    fun bind(note: Note) {
        Log.v("Note", note.title)
        title.text = note.title
        body.text = note.note
        itemView.setBackgroundColor(note.color)
    }

}