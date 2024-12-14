package com.example.presentation.views.todo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.presentation.R
import com.example.presentation.databinding.ActivityTodoBinding
import com.example.presentation.viewmodels.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoActivity : AppCompatActivity() {

    private val TAG = this::class.simpleName

    private val todoViewModel: TodoViewModel by viewModels()

    private lateinit var binding: ActivityTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.todo_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()

        todoViewModel.loadTodos()

        observeViewModel()
    }

    private fun initRecyclerView() {
        //
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            todoViewModel.todos.collect { todos ->
                Log.e(TAG, "## todos : $todos")
            }
        }
    }

}