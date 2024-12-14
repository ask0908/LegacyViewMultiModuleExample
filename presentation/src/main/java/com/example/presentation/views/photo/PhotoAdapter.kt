package com.example.presentation.views.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.PhotoEntity
import com.example.presentation.databinding.ItemPhotoBinding
import com.example.presentation.views.util.MyDiffUtil

class PhotoAdapter : ListAdapter<PhotoEntity, PhotoAdapter.PhotoViewHolder>(
    MyDiffUtil(
        idSelector = { it.id },
        contentComparator = { old,new -> old == new }
    )
) {

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PhotoEntity) {
            binding.photoData = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
        holder.bind(getItem(position))

}