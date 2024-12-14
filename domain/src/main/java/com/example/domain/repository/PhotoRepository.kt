package com.example.domain.repository

import com.example.domain.entity.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    fun getPhotos(): Flow<Result<List<PhotoEntity>>>
}