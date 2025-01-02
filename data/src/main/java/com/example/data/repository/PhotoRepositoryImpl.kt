package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.mapper.PhotoMapper
import com.example.data.model.response.PhotoResponse
import com.example.data.util.performApiCall
import com.example.domain.entity.PhotoEntity
import com.example.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val photoMapper: PhotoMapper,
): PhotoRepository {
    override fun getPhotos(): Flow<Result<List<PhotoEntity>>> = performApiCall(
        funcName = "getPhotos()",
        apiCall = { apiService.getPhotos() }
    ).map { result ->
        result.mapCatching { response: List<PhotoResponse> ->
            response.map(photoMapper::mapToDomain)
        }
    }
}