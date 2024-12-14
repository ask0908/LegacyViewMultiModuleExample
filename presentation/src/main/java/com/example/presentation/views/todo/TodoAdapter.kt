package com.example.presentation.views.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.TodoEntity
import com.example.presentation.databinding.ItemTodoBinding
import com.example.presentation.views.util.MyDiffUtil

class TodoAdapter: ListAdapter<TodoEntity, TodoAdapter.TodoViewHolder>(
    MyDiffUtil(
        idSelector = { it.id },
        contentComparator = { old, new -> old == new }
    )
) {

    inner class TodoViewHolder(private val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoEntity) {
            binding.todoData = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) =
        holder.bind(getItem(position))

}