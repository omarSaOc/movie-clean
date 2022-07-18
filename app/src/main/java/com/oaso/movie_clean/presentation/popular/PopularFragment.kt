package com.oaso.movie_clean.presentation.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.oaso.core.data.Movie
import com.oaso.movie_clean.databinding.FragmentPopularBinding
import com.oaso.movie_clean.framework.viewmodels.PopularViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment() {

    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PopularViewModel by viewModels()
    private lateinit var adapter: PopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        adapter = PopularAdapter(::navigateDetailMovie)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPopularMovies()
        observer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        viewModel.movie.observe(viewLifecycleOwner, ::getPopularMovies)
        viewModel.loading.observe(viewLifecycleOwner, ::getLoading)
    }

    private fun getPopularMovies(movies: List<Movie>) {
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
        val action = PopularFragmentDirections.actionNavigationPopularToNavigationDetailMovie(movie)
        Navigation.findNavController(binding.rvMovies).navigate(action)
    }
}