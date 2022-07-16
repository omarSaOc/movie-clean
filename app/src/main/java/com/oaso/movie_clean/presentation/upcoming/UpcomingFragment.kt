package com.oaso.movie_clean.presentation.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.oaso.core.data.Movie
import com.oaso.movie_clean.databinding.FragmentUpcomingBinding
import com.oaso.movie_clean.framework.viewmodels.UpcomingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpcomingFragment : Fragment() {

    private var _binding: FragmentUpcomingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UpcomingViewModel by viewModels()
    private lateinit var adapter: UpcomingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)
        adapter = UpcomingAdapter(::navigateDetailMovie)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUpcoming()
        observer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        viewModel.movie.observe(viewLifecycleOwner, ::getUpcomingMovies)
        viewModel.loading.observe(viewLifecycleOwner, ::getLoading)
    }

    private fun getUpcomingMovies(movies: List<Movie>) {
        adapter.movies = movies
        binding.rvMovies.adapter = adapter
    }

    private fun getLoading(loading: Boolean) {
        if (loading) {
            binding.rvMovies.visibility = View.GONE
            binding.pbLoadMovies.visibility = View.VISIBLE
        } else {
            binding.rvMovies.visibility = View.VISIBLE
            binding.pbLoadMovies.visibility = View.GONE
        }
    }

    private fun navigateDetailMovie(movie: Movie) {

    }
}