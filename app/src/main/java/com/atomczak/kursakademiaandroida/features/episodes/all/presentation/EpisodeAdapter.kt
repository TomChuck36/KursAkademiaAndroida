package com.atomczak.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atomczak.kursakademiaandroida.databinding.TextItemBinding
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter :
    ListAdapter<EpisodeDisplayable, EpisodeAdapter.EpisodeViewHolder>(EpisodeDiffCallback) {

    var onClickItem: ((EpisodeDisplayable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeViewHolder(
        TextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickItem
    )

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EpisodeViewHolder(
        private val binding: TextItemBinding,
        private val onClickItem: ((EpisodeDisplayable) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            binding.textView.text = episode.name
            binding.root.setOnClickListener { onClickItem?.invoke(episode) }
        }
    }

    object EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeDisplayable>() {
        override fun areItemsTheSame(oldItem: EpisodeDisplayable, newItem: EpisodeDisplayable) =
            (oldItem.toString() == newItem.toString())

        override fun areContentsTheSame(oldItem: EpisodeDisplayable, newItem: EpisodeDisplayable) =
            (oldItem == newItem)
    }
}