package com.iesam.androidtraining2.features.movies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iesam.androidtraining2.R
import com.iesam.androidtraining2.features.movies.domain.Movie

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_movie_item, viewGroup, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        viewHolder.bind(movies[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = movies.size

    fun setMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
}