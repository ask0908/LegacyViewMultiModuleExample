package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.mapper.AlbumMapper
import com.example.data.model.AlbumResponse
import com.example.data.util.performApiCall
import com.example.domain.entity.AlbumEntity
import com.example.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val albumMapper: AlbumMapper,
): AlbumRepository {
    override fun getAlbums(): Flow<Result<List<AlbumEntity>>> = performApiCall(
        funcName = "getAlbums()",
        apiCall = { apiService.getAlbums() }
    ).map { result ->
        result.mapCatching { response: List<AlbumResponse> ->
            response.map(albumMapper::mapToDomain)
        }
    }
}