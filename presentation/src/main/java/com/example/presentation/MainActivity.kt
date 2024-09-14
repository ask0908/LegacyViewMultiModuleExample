package com.example.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName

    private lateinit var binding: ActivityMainBinding
    private val albumViewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.run {
            lifecycleOwner = this@MainActivity
        }

        albumViewModel.loadAlbums()

        lifecycleScope.launch {
            albumViewModel.albums.collect {
                Log.e(TAG, "Album 리스트 : $it")
                if (it.isNotEmpty()) {
                    binding.tvText.text = "0번 제목 : ${it[0].title}" + "\n" + "1번 제목 : ${it[1].title}"
                }
            }
        }
    }
}