package com.example.domain.repository

import com.example.domain.model.Album

class GetAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {
    suspend operator fun invoke(): List<Album> = albumRepository.getAlbums()
}