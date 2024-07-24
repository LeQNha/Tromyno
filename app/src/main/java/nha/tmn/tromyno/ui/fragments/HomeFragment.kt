package nha.tmn.tromyno.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import nha.tmn.tromyno.R
import nha.tmn.tromyno.adapters.ViewPagerAdapter

class HomeFragment : Fragment() {
    private lateinit var homeFragmentTabLayout: TabLayout
    private lateinit var homeFragmentViewPager2: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeFragmentTabLayout = view.findViewById(R.id.homeFragmetTabLayout)
        homeFragmentViewPager2 = view.findViewById(R.id.homeFragmentViewPager2)
        viewPagerAdapter = ViewPagerAdapter(this)
        homeFragmentViewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(homeFragmentTabLayout, homeFragmentViewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "Apod"
                1 -> "NeoWs"
                2 -> "MRP"
                3 -> "Epic"
                else -> null
            }
        }.attach()
    }
}