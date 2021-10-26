package com.example.w6_d1_note_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.w6_d1_note_app.MainActivity
import com.example.w6_d1_note_app.R
import com.example.w6_d1_note_app.NoteModel
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter (
    private val activity: MainActivity,
    private val items: ArrayList<NoteModel>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.ItemViewHolder, position: Int) {
        val item = items[position]

        holder.itemView.apply {
            noteTextView.text = item.noteText
        }
    }

    override fun getItemCount() = items.size
}