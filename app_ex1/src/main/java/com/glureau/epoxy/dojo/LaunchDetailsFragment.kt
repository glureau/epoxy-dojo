package com.glureau.epoxy.dojo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import com.glureau.epoxy.dojo.controllers.LaunchDetailsController
import com.glureau.epoxy.dojo.data.dto.Launch
import kotlinx.android.synthetic.main.fragment_launch_details.*

class LaunchDetailsFragment : Fragment(R.layout.fragment_launch_details) {

    companion object {
        private val ARG = "launch"
        fun newInstance(launch: Launch) = LaunchDetailsFragment().apply {
            arguments = bundleOf(ARG to launch)
        }
    }

    private val launch by lazy { requireArguments().getParcelable<Launch>(ARG) }
    private val launchDetailsController by lazy { LaunchDetailsController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launch_details_recycler_view.setController(launchDetailsController)
    }

    override fun onResume() {
        super.onResume()
        launchDetailsController.setData(launch)
    }
}