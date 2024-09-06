package com.iesam.androidtraining2.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesam.androidtraining2.features.movies.domain.GetMoviesUseCase
import com.iesam.androidtraining2.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState


    fun onCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()
            _uiState.postValue(UiState(movies = movies))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        //val errorApp: ErrorUiModel? = null,
        val movies: List<Movie>? = null
    )
}