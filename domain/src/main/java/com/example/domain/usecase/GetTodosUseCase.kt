package com.example.domain.usecase

import com.example.domain.entity.TodoEntity
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodosUseCase(
    private val todoRepository: TodoRepository
) {
    operator fun invoke(): Flow<Result<List<TodoEntity>>> = todoRepository.getTodos()
}