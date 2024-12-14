package com.example.data.mapper

import com.example.data.model.response.PhotoResponse
import com.example.domain.entity.PhotoEntity

class PhotoMapper {
    fun mapToDomain(photoResponse: PhotoResponse): PhotoEntity =
        PhotoEntity(
            photoResponse.albumId,
            photoResponse.id,
            photoResponse.title,
            photoResponse.url,
            photoResponse.thumbnailUrl,
        )
}