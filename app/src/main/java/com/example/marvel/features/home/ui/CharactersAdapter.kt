package com.example.marvel.features.home.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.core.extensions.inflate
import com.example.marvel.features.home.domain.model.Character
import kotlin.properties.Delegates

class CharactersAdapter
    : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    internal var collection: List<Character> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (Character) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_character))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(characterView: Character, clickListener: (Character) -> Unit) {
            //TODO populate view
        }
    }
}