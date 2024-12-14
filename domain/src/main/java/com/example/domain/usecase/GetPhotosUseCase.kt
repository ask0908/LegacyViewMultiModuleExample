package com.example.domain.usecase

import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow

class GetPhotosUseCase(
    private val photoRepository: PhotoRepository
) {
    operator fun invoke(): Flow<Result<List<PhotoEntity>>> = photoRepository.getPhotos()
}