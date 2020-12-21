package net.android.projectapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_fragment.view.*
import net.android.projectapp.R
import net.android.projectapp.ui.adapters.ViewPagerAdapter
import net.android.projectapp.ui.fragments.Videofragment
import net.android.projectapp.ui.fragments.VisitFragment
import net.android.projectapp.viewmodel.MyViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        lateinit var rootView: View
        fun getItemLayout(item: Int) {
            rootView.tabLayout.selectTab(rootView.tabLayout.getTabAt(item))
        }
    }

    val myViewModel: MyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.main_fragment, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        myViewModel.jsonLivedata.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "onActivityCreated: ${it}")
            VisitFragment.jsonData = listOf(it)
            Videofragment.jsonData = listOf(it)
            var viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
            rootView.viewPager.adapter = viewPagerAdapter
        })

        rootView.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                rootView.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}