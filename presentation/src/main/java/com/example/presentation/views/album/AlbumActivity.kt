package com.example.presentation.views.album

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.presentation.R
import com.example.presentation.databinding.ActivityAlbumBinding
import com.example.presentation.viewmodels.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlbumActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName

    private lateinit var binding: ActivityAlbumBinding
    private val albumViewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        albumViewModel.loadAlbums()

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            albumViewModel.albums.collect {
                if (it.isNotEmpty()) {
                    // 리사이클러뷰 세팅
                }
            }
        }

        lifecycleScope.launch {
            albumViewModel.error.collect {
                Log.e(TAG, "error : $it")
            }
        }
    }

}