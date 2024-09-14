package com.example.domain.mapper

import com.example.domain.model.Album

interface AlbumDomainMapper<T> {
    fun mapFromDomain(album: Album): T
    fun mapToDomain(type: T): Album
}