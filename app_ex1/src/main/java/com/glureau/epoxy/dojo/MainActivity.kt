package com.glureau.epoxy.dojo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.glureau.epoxy.dojo.data.dto.Launch

class MainActivity : AppCompatActivity(), LaunchesFragment.LaunchesFragmentListener,
    LaunchesWithDetailsFragment.LaunchesWithDetailsFragmentListener {

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, LaunchesFragment.newInstance())
            .commit()
    }

    override fun onBackPressed() {
        val frag =
            if (index++ % 2 == 0) LaunchesFragment.newInstance() else LaunchesWithDetailsFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, frag)
            .commit()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is LaunchesFragment) {
            fragment.listener = this
        }
        if (fragment is LaunchesWithDetailsFragment) {
            fragment.listener = this
        }
    }

    override fun onLaunchClicked(launch: Launch) {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, LaunchDetailsFragment.newInstance(launch))
            .addToBackStack(null)
            .commit()
    }
}
