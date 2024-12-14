package com.example.presentation.views.util

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil<T: Any>(
    private val idSelector: (T) -> Any,
    private val contentComparator: (T, T) -> Boolean = { old, new -> old == new }
): DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        idSelector(oldItem) == idSelector(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        contentComparator(oldItem, newItem)
}