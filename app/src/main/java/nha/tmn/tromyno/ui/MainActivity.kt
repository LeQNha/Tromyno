package nha.tmn.tromyno.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import nha.tmn.tromyno.R
import nha.tmn.tromyno.ui.fragments.HomeFragment
import nha.tmn.tromyno.ui.fragments.SavedFragment
import nha.tmn.tromyno.ui.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavView: BottomNavigationView
    val homeFragment = HomeFragment()
    val searchFragment = SearchFragment()
    val savedFragment = SavedFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.bottomNavView)
        replaceFragment(homeFragment)
        setUpBottomNavView()
    }

    fun setUpBottomNavView() {
        bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragmentNav -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.searchFragmentNav -> {
                    replaceFragment(searchFragment)
                    true
                }

                R.id.savedFragmentNav -> {
                    replaceFragment(savedFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}