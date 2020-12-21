package net.android.projectapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import net.android.projectapp.ui.MainFragment
import net.android.projectapp.ui.fragments.Videofragment
import net.android.projectapp.ui.fragments.VisitFragment

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    val items = 2
    override fun getItemCount(): Int {
        return items
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> VisitFragment()
            1 -> Videofragment()
            else -> VisitFragment()
        }
    }

    override fun getItemId(position: Int): Long {
        MainFragment.getItemLayout(position)
        return super.getItemId(position)
    }
}
