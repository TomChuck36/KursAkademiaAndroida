package com.atomczak.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atomczak.kursakademiaandroida.databinding.TextItemBinding
import com.atomczak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter :
    ListAdapter<CharacterDisplayable, CharacterAdapter.CharacterViewHolder>(CharacterDiffCallback) {

    var onClickItem: ((CharacterDisplayable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        TextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickItem
    )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CharacterViewHolder(
        private val binding: TextItemBinding,
        private val onClickItem: ((CharacterDisplayable) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            binding.textView.text = character.name
            binding.root.setOnClickListener { onClickItem?.invoke(character) }
        }
    }

    object CharacterDiffCallback : DiffUtil.ItemCallback<CharacterDisplayable>() {
        override fun areItemsTheSame(oldItem: CharacterDisplayable, newItem: CharacterDisplayable) =
            (oldItem.toString() == newItem.toString())

        override fun areContentsTheSame(oldItem: CharacterDisplayable, newItem: CharacterDisplayable) =
            (oldItem == newItem)
    }
}