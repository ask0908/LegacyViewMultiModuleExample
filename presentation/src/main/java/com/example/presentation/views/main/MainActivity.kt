package com.example.presentation.views.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.views.album.AlbumActivity
import com.example.presentation.views.photo.PhotoActivity
import com.example.presentation.views.todo.TodoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()
    }

    private fun initView() {
        binding.run {
            btnAlbums.setOnClickListener {
                startActivity(Intent(this@MainActivity, AlbumActivity::class.java))
            }

            btnPhotos.setOnClickListener {
                startActivity(Intent(this@MainActivity, PhotoActivity::class.java))
            }

            btnTodos.setOnClickListener {
                startActivity(Intent(this@MainActivity, TodoActivity::class.java))
            }
        }
    }

}