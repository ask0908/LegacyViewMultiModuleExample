package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.AlbumEntity
import com.example.domain.usecase.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
): ViewModel() {

    private val _albums = MutableStateFlow<List<AlbumEntity>>(emptyList())
    val albums: StateFlow<List<AlbumEntity>> = _albums.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadAlbums() = viewModelScope.launch(Dispatchers.IO) {
        getAlbumsUseCase().collect { result ->
            result.fold(
                onSuccess = { albums ->
                    _albums.value = albums
                },
                onFailure = { e ->
                    _error.value = e.message
                }
            )
        }
    }

}