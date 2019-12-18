package com.glureau.epoxy.dojo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.glureau.epoxy.data.dto.Launch
import com.glureau.epoxy.dojo.ui.fragments.LaunchDetailsFragment
import com.glureau.epoxy.dojo.ui.fragments.LaunchesFragment
import com.glureau.epoxy.dojo.ui.fragments.LaunchesWithDetailsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), LaunchesFragment.LaunchesFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener {
            val frag = when (it.itemId) {
                R.id.navigation_home -> LaunchesFragment.newInstance()
                R.id.navigation_dashboard -> LaunchesFragment.newInstance()
                else -> LaunchesWithDetailsFragment.newInstance()
            }
            navigateTo(frag)
            true
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LaunchesFragment.newInstance())
            .commit()
    }

    private fun navigateTo(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frag)
            .addToBackStack(null)
            .commit()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is LaunchesFragment) {
            fragment.listener = this
        }
    }

    override fun onLaunchClicked(launch: Launch) {
        navigateTo(LaunchDetailsFragment.newInstance(launch))
    }
}
