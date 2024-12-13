package com.example.domain.usecase

import com.example.domain.entity.AlbumEntity
import com.example.domain.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow

class GetAlbumsUseCase(
    private val albumRepository: AlbumRepository
) {
    operator fun invoke(): Flow<Result<List<AlbumEntity>>> = albumRepository.getAlbums()
}