package com.oaso.movie_clean.presentation.detail_movie

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oaso.core.data.Video
import com.oaso.movie_clean.R
import com.oaso.movie_clean.databinding.ItemVideoBinding
import com.oaso.movie_clean.utils.basicDiffUtil
import com.oaso.movie_clean.utils.inflate

class VideoAdapter(val listener: (video: Video) -> Unit) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    var list: List<Video> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = parent.inflate(R.layout.item_video, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = list[position]
        holder.bind(video)
        holder.itemView.setOnClickListener { listener(video) }
    }

    override fun getItemCount(): Int = list.size

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemVideoBinding.bind(itemView)

        fun bind(video: Video) = with(binding) {
            nameVideo.text = video.name
        }
    }
}