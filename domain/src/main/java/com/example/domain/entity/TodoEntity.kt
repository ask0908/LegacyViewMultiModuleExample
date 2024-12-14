package com.example.domain.entity

data class TodoEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)