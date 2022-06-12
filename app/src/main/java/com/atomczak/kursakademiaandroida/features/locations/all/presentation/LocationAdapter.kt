package com.atomczak.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atomczak.kursakademiaandroida.databinding.TextItemBinding
import com.atomczak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationAdapter :
    ListAdapter<LocationDisplayable, LocationAdapter.LocationViewHolder>(LocationDiffCallback) {

    var onClickItem: ((LocationDisplayable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LocationViewHolder(
        TextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onClickItem
    )

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LocationViewHolder(
        private val binding: TextItemBinding,
        private val onClickItem: ((LocationDisplayable) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            binding.textView.text = location.name
            binding.root.setOnClickListener { onClickItem?.invoke(location) }
        }
    }

    object LocationDiffCallback : DiffUtil.ItemCallback<LocationDisplayable>() {
        override fun areItemsTheSame(oldItem: LocationDisplayable, newItem: LocationDisplayable) =
            (oldItem.toString() == newItem.toString())

        override fun areContentsTheSame(oldItem: LocationDisplayable, newItem: LocationDisplayable) =
            (oldItem == newItem)
    }
}