package com.example.domain.repository

import com.example.domain.model.Album

interface AlbumRepository {
    suspend fun getAlbums(): List<Album>
}