package com.example.multimoduleexample.di

import com.example.domain.repository.AlbumRepository
import com.example.domain.repository.PhotoRepository
import com.example.domain.repository.TodoRepository
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.domain.usecase.GetPhotosUseCase
import com.example.domain.usecase.GetTodosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetAlbumsUseCase(albumRepository: AlbumRepository): GetAlbumsUseCase =
        GetAlbumsUseCase(albumRepository)

    @Provides
    @Singleton
    fun provideGetPhotosUseCase(photoRepository: PhotoRepository): GetPhotosUseCase =
        GetPhotosUseCase(photoRepository)

    @Provides
    @Singleton
    fun provideGetTodosUseCase(todoRepository: TodoRepository): GetTodosUseCase =
        GetTodosUseCase(todoRepository)

}