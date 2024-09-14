package com.example.multimoduleexample.di

import com.example.domain.repository.AlbumRepository
import com.example.domain.repository.GetAlbumsUseCase
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
}