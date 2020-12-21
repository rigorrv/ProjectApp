package net.android.projectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import net.android.projectapp.databinding.VisitFragmentBinding
import net.android.projectapp.model.JsonData

class VisitFragment : Fragment() {

    private lateinit var fragmentVisitFragmentBinding: VisitFragmentBinding

    companion object {
        var jsonData: List<JsonData> = mutableListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentVisitFragmentBinding = VisitFragmentBinding.inflate(inflater, container, false)
        return fragmentVisitFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        for (json in jsonData) {
            fragmentVisitFragmentBinding.visit = json.visit
            Glide.with(this)
                .load(json.visit.image)
                .into(fragmentVisitFragmentBinding.imageVisit)
        }
    }


}