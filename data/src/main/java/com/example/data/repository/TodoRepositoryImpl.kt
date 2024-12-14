package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.mapper.TodoMapper
import com.example.data.model.response.TodoResponse
import com.example.data.util.performApiCall
import com.example.domain.entity.TodoEntity
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val todoMapper: TodoMapper,
): TodoRepository {
    override fun getTodos(): Flow<Result<List<TodoEntity>>> = performApiCall(
        funcName = "getTodos()",
        apiCall = { apiService.getTodos() }
    ).map { result ->
        result.mapCatching { response: List<TodoResponse> ->
            response.map(todoMapper::mapToDomain)
        }
    }
}