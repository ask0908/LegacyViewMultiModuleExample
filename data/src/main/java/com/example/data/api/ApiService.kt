package com.example.data.api

import com.example.data.model.response.AlbumResponse
import com.example.data.model.response.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): Response<List<AlbumResponse>>

    @GET("photos")
    suspend fun getPhotos(): Response<List<PhotoResponse>>
}