package com.glureau.epoxy.dojo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import com.glureau.epoxy.dojo.data.DataRepository
import com.glureau.epoxy.dojo.controllers.LaunchersController
import com.glureau.epoxy.dojo.controllers.LaunchersWithDetailsController
import com.glureau.epoxy.dojo.data.dto.Launch
import kotlinx.android.synthetic.main.fragment_launches.*

class LaunchesWithDetailsFragment : Fragment(R.layout.fragment_launches) {

    companion object {
        fun newInstance() = LaunchesWithDetailsFragment()
    }

    interface LaunchesWithDetailsFragmentListener {
        fun onLaunchClicked(launch: Launch)
    }

    var listener: LaunchesWithDetailsFragmentListener? = null
    private val launchersController by lazy { LaunchersWithDetailsController(listener) }
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