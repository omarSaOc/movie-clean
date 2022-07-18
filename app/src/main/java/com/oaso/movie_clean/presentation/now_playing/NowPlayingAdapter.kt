package com.oaso.movie_clean.presentation.now_playing

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oaso.core.data.Movie
import com.oaso.movie_clean.R
import com.oaso.movie_clean.databinding.ItemMovieBinding
import com.oaso.movie_clean.utils.basicDiffUtil
import com.oaso.movie_clean.utils.inflate
import com.oaso.movie_clean.utils.loadUrl

class NowPlayingAdapter(
    private val listener: (Movie) -> Unit
) : RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>() {

    var movies: List<Movie> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        val view = parent.inflate(R.layout.item_movie, false)
        return NowPlayingViewHolder(view)
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    override fun getItemCount(): Int = movies.size

    inner class NowPlayingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMovieBinding.bind(itemView)

        fun bind(movie: Movie) = with(binding) {
            movieTitle.text = movie.title
            moviePoster.loadUrl("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
        }
    }
}