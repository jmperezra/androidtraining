package com.iesam.androidtraining2.features.movies.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iesam.androidtraining2.databinding.ViewMovieItemBinding
import com.iesam.androidtraining2.features.movies.domain.Movie

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val bind = ViewMovieItemBinding.bind(view)

    fun bind(movie: Movie) {
        Glide.with(view.context)
            .load(movie.poster)
            .into(bind.coverMovie)

        bind.labelTitle.text = movie.title
        bind.labelYear.text = movie.year
    }
}