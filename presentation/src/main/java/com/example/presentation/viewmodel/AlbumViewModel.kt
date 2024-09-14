package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Album
import com.example.domain.repository.GetAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase
): ViewModel() {

    private val TAG = this::class.simpleName

    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums: StateFlow<List<Album>> = _albums.asStateFlow()

    fun loadAlbums() {
        viewModelScope.launch {
            try {
                val result = getAlbumsUseCase()
                Log.e(TAG, "result : $result")
                _albums.value = result
            } catch (e: Exception) {
                Log.e(TAG, "뷰모델에서 에러 발생 : ${e.message}")
            }
        }
    }

}