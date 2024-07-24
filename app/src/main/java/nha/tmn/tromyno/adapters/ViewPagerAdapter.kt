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

//    private val apodFragment = ApodFragment()
//    private val epicFragment = EpicFragment()
//    private val mrpFragment = MrpFragment()
//    private val neowsFragment = NeowsFragment()

    private val fragmentList =
        listOf<Fragment>(
            ApodFragment(),
            EpicFragment(),
            MrpFragment(),
            NeowsFragment()
        )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

//    override fun createFragment(position: Int): Fragment {
//        return when (position) {
//            0 -> ApodFragment()
//            1 -> NeowsFragment()
//            2 -> MrpFragment()
//            3 -> EpicFragment()
//            else -> ApodFragment()
//        }
//    }

    override fun createFragment(position: Int): Fragment = fragmentList[position]


}