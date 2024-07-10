package nha.tmn.tromyno.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import nha.tmn.tromyno.ui.fragments.tabFragments.ApodFragment
import nha.tmn.tromyno.ui.fragments.tabFragments.EpicFragment
import nha.tmn.tromyno.ui.fragments.tabFragments.MrpFragment
import nha.tmn.tromyno.ui.fragments.tabFragments.NeowsFragment

class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    private val apodFragment = ApodFragment()
    private val epicFragment = EpicFragment()
    private val mrpFragment = MrpFragment()
    private val neowsFragment = NeowsFragment()
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> apodFragment
            1 -> neowsFragment
            2 -> mrpFragment
            3 -> epicFragment
            else -> apodFragment
        }
    }
}