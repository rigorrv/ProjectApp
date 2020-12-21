package net.android.projectapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.video_items.view.*
import net.android.projectapp.R
import net.android.projectapp.model.Video

class VideoAdapter : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    var videoList: List<Video> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.video_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.ViewHolder, position: Int) {
        holder.onBind(videoList[position])
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titleVideo = itemView.titleVideo
        val imageVideo = itemView.imageVideo
        fun onBind(videoList: Video) {
            titleVideo.text = videoList.title
            Glide.with(itemView)
                .load(videoList.image)
                .into(imageVideo)
        }


    }

}