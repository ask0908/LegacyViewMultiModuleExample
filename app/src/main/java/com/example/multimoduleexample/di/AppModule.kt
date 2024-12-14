package com.example.multimoduleexample.di

import com.example.data.api.ApiService
import com.example.data.mapper.AlbumMapper
import com.example.data.mapper.PhotoMapper
import com.example.data.mapper.TodoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun providePhotoMapper(): PhotoMapper = PhotoMapper()

    @Provides
    @Singleton
    fun provideTodoMapper(): TodoMapper = TodoMapper()

}