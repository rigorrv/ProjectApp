package net.android.projectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.android.projectapp.databinding.VideoFragmentBinding
import net.android.projectapp.model.JsonData
import net.android.projectapp.ui.adapters.VideoAdapter

class Videofragment : Fragment() {

    lateinit var videoFragmentBinding: VideoFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    val videAdapter = VideoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        videoFragmentBinding = VideoFragmentBinding.inflate(inflater, container, false)
        return videoFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (json in jsonData) {
            videAdapter.videoList = json.video
            videoFragmentBinding.videoRecycler.adapter = videAdapter
        }
    }


}