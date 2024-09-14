package com.example.data.mapper

import com.example.data.model.AlbumResponse
import com.example.domain.model.Album

class AlbumMapper {
    fun mapToDomain(albumResponse: AlbumResponse): Album =
        Album(
            id = albumResponse.id,
            userId = albumResponse.userId,
            title = albumResponse.title,
        )

    fun mapToData(album: Album): AlbumResponse =
        AlbumResponse(
            userId = album.id,
            id = album.userId,
            title = album.title,
        )
}