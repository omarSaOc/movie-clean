package com.oaso.movie_clean.presentation.popular

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oaso.core.data.Movie
import com.oaso.movie_clean.R
import com.oaso.movie_clean.databinding.ItemMovieBinding
import com.oaso.movie_clean.utils.basicDiffUtil
import com.oaso.movie_clean.utils.inflate
import com.oaso.movie_clean.utils.loadUrl

class PopularAdapter(
    private val listener: (Movie) -> Unit
) :
    RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    var movies: List<Movie> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = parent.inflate(R.layout.item_movie, false)
        return PopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    override fun getItemCount(): Int = movies.size

    inner class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemMovieBinding.bind(itemView)

        fun bind(movie: Movie) = with(binding) {
            movieTitle.text = movie.title
            moviePoster.loadUrl("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
        }

    }
}