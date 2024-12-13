package com.example.domain.repository

import com.example.domain.entity.AlbumEntity
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    fun getAlbums(): Flow<Result<List<AlbumEntity>>>
}