package com.example.presentation.views.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.AlbumEntity
import com.example.presentation.R
import com.example.presentation.databinding.ItemAlbumBinding

class AlbumAdapter: ListAdapter<AlbumEntity, AlbumAdapter.AlbumViewHolder>(DIFF_UTIL) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<AlbumEntity>() {
            override fun areItemsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: AlbumEntity, newItem: AlbumEntity): Boolean =
                oldItem == newItem

        }
    }

    inner class AlbumViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AlbumEntity) {
            binding.albumData = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bind(getItem(position))
}