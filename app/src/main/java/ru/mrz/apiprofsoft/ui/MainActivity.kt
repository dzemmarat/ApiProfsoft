package ru.mrz.apiprofsoft.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mrz.apiprofsoft.databinding.ActivityMainBinding
import ru.mrz.apiprofsoft.ui.adapter.NotesAdapter
import ru.mrz.apiprofsoft.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getNote().collect {
                withContext(Dispatchers.Main) {
                    binding.recyclerView.adapter = NotesAdapter(it)
                    binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }
}