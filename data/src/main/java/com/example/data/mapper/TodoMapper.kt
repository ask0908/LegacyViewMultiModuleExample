package com.example.data.mapper

import com.example.data.model.response.TodoResponse
import com.example.domain.entity.TodoEntity

class TodoMapper {
    fun mapToDomain(todoResponse: TodoResponse): TodoEntity =
        TodoEntity(
            userId = todoResponse.userId,
            id = todoResponse.id,
            title = todoResponse.title,
            completed = todoResponse.completed
        )
}