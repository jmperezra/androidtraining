package com.iesam.androidtraining2.features.movies.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.iesam.androidtraining2.databinding.ActivityMoviesBinding
import com.iesam.androidtraining2.features.movies.MovieFactory

class MoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesBinding
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    private val movieAdapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        movieFactory = MovieFactory(this)
        viewModel = movieFactory.provideViewModel()
        setContentView(binding.root)
        setupView()
        setupObserver()
        viewModel.onCreated()
    }

    private fun setupView() {
        binding.topbar.setNavigationOnClickListener {
            finish()
        }
        binding.moviesList.apply {
            addItemDecoration(
                DividerItemDecoration(
                    this@MoviesActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
            layoutManager = LinearLayoutManager(this@MoviesActivity)
            adapter = movieAdapter
        }

    }

    private fun setupObserver() {
        val observer = Observer<MoviesViewModel.UiState> { uiState ->
            if (uiState.isLoading) {
                //showloading
            } else {
                uiState.movies?.let {
                    movieAdapter.setMovies(uiState.movies)
                }
            }
        }
        viewModel.uiState.observe(this, observer)
    }

}