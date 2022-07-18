package com.oaso.movie_clean.presentation.detail_movie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.oaso.core.data.Movie
import com.oaso.core.data.Video
import com.oaso.movie_clean.R
import com.oaso.movie_clean.databinding.FragmentDetailMovieBinding
import com.oaso.movie_clean.framework.viewmodels.DetailMovieViewModel
import com.oaso.movie_clean.utils.getDivider
import com.oaso.movie_clean.utils.loadUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieFragment : Fragment() {

    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding
    private val viewModel: DetailMovieViewModel by viewModels()
    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
        arguments.let {
            movie = DetailMovieFragmentArgs.fromBundle(it!!).movie
            with(binding) {
                this?.ivMovie?.loadUrl("https://image.tmdb.org/t/p/w780${movie.backdrop_path}")
                this?.tbMovieDetail?.title = movie.title
                this?.tvMovieSummary?.text = movie.overview
                this?.movieDetailInfo?.setMovie(movie)
                this?.playVideo?.setOnClickListener {
                    viewModel.getVideos(movie.id)
                }
            }
        }
    }

    private fun observer() {
        viewModel.videos.observe(viewLifecycleOwner, ::getAllVideos)
    }

    private fun getAllVideos(videos: List<Video>) {
        val dialog = BottomSheetDialog(requireContext())
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        val rvVideos = view.findViewById<RecyclerView>(R.id.rv_videos)
        rvVideos.addItemDecoration(getDivider(requireContext()))
        val adapter = VideoAdapter(::playVideo)
        adapter.list = videos
        rvVideos.adapter = adapter
        dialog.setContentView(view)
        dialog.show()
    }

    private fun playVideo(video: Video) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:${video.key}"))
        intent.putExtra("force_fullscreen", true)
        startActivity(intent)
    }
}