package com.oaso.movie_clean.presentation.detail_movie

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.oaso.core.data.Movie

class MovieDetailInfoView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    fun setMovie(movie : Movie) {
        text = buildSpannedString {
            bold { append("Original language: ") }
            appendLine(movie.original_language)

            bold { append("Original title: ") }
            appendLine(movie.original_title)

            bold { append("Release date: ") }
            appendLine(movie.release_date)

            bold { append("Popularity: ") }
            appendLine(movie.popularity.toString())

            bold { append("Vote Average: ") }
            append(movie.vote_average.toString())
        }
    }
}