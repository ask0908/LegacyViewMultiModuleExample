package com.example.data.mapper

import com.example.data.model.response.AlbumResponse
import com.example.domain.entity.AlbumEntity

class AlbumMapper {
    fun mapToDomain(albumResponse: AlbumResponse): AlbumEntity =
        AlbumEntity(
            id = albumResponse.id,
            userId = albumResponse.userId,
            title = albumResponse.title,
        )
}