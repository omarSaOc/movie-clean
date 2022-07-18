package com.oaso.movie_clean.presentation.now_playing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.oaso.core.data.Movie
import com.oaso.movie_clean.databinding.FragmentNowPlayingBinding
import com.oaso.movie_clean.framework.viewmodels.NowPlayingViewModel
import com.oaso.movie_clean.presentation.popular.PopularFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NowPlayingFragment : Fragment() {

    private var _binding: FragmentNowPlayingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NowPlayingViewModel by viewModels()
    private lateinit var adapter: NowPlayingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNowPlayingBinding.inflate(inflater, container, false)
        adapter = NowPlayingAdapter(::navigateDetailMovie)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNowPlaying()
        observer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        viewModel.movie.observe(viewLifecycleOwner, ::getNowPlayingMovies)
        viewModel.loading.observe(viewLifecycleOwner, ::getLoading)
    }

    private fun getNowPlayingMovies(movies: List<Movie>) {
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
        val action =
            NowPlayingFragmentDirections.actionNavigationNowPlayingToNavigationDetailMovie(movie)
        Navigation.findNavController(binding.rvMovies).navigate(action)
    }
}