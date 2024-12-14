package com.example.domain.repository

import com.example.domain.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<Result<List<TodoEntity>>>
}