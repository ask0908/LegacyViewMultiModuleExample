package com.example.multimoduleexample.di

import com.example.data.api.ApiService
import com.example.data.mapper.AlbumMapper
import com.example.data.repository.AlbumRepositoryImpl
import com.example.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideAlbumMapper(): AlbumMapper = AlbumMapper()

    @Provides
    @Singleton
    fun provideAlbumRepository(
        apiService: ApiService,
        albumMapper: AlbumMapper
    ): AlbumRepository = AlbumRepositoryImpl(apiService, albumMapper)
}