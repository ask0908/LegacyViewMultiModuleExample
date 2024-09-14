package com.example.data.api

import com.example.data.model.AlbumResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("albums")
    suspend fun getAlbums(): Response<List<AlbumResponse>>
}