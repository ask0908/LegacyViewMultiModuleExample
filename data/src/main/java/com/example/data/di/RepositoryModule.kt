package com.example.data.di

import com.example.data.repository.AlbumRepositoryImpl
import com.example.data.repository.PhotoRepositoryImpl
import com.example.data.repository.TodoRepositoryImpl
import com.example.domain.repository.AlbumRepository
import com.example.domain.repository.PhotoRepository
import com.example.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAlbumRepository(impl: AlbumRepositoryImpl): AlbumRepository

    @Binds
    @Singleton
    abstract fun bindPhotoRepository(impl: PhotoRepositoryImpl): PhotoRepository

    @Binds
    @Singleton
    abstract fun bindTodoRepository(impl: TodoRepositoryImpl): TodoRepository
}