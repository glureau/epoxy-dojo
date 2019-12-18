package com.glureau.epoxy.dojo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.glureau.epoxy.data.DataRepository
import com.glureau.epoxy.dojo.controllers.LaunchersController
import com.glureau.epoxy.data.dto.Launch
import kotlinx.android.synthetic.main.fragment_launches.*

class LaunchesFragment : Fragment(R.layout.fragment_launches) {

    companion object {
        fun newInstance() = LaunchesFragment()
    }

    interface LaunchesFragmentListener {
        fun onLaunchClicked(launch: Launch)
    }

    var listener: LaunchesFragmentListener? = null
    private val launchersController by lazy { LaunchersController(listener) }
    private val data by lazy { DataRepository().getSpaceXLaunches(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchers_recycler_view.setController(launchersController)
    }

    override fun onResume() {
        super.onResume()
        launchersController.setData(data)
    }
}