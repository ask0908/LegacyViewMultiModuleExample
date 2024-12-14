package com.example.presentation.views.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.AlbumEntity
import com.example.presentation.databinding.ItemAlbumBinding
import com.example.presentation.views.util.MyDiffUtil

class AlbumAdapter: ListAdapter<AlbumEntity, AlbumAdapter.AlbumViewHolder>(
    MyDiffUtil(
        idSelector = { it.id },
        contentComparator = { old, new -> old == new }
    )
) {

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