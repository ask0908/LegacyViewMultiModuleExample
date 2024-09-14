package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.mapper.AlbumMapper
import com.example.domain.model.Album
import com.example.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val albumMapper: AlbumMapper,
): AlbumRepository {
    override suspend fun getAlbums(): List<Album> {
        val response = apiService.getAlbums()
        return response.body()?.map {
            albumMapper.mapToDomain(it)
        } ?: throw Exception("error : ${response.errorBody()}")
    }
}