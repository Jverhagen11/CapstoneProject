package com.example.capstoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.capstoneproject.Model.Models.Standings.DriverRoot
import kotlinx.android.synthetic.main.fragment_overview_standing.*

class OverviewStandingFragment: Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview_standing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeFragmentResult()

    }

    private fun observeFragmentResult() {
        setFragmentResultListener(REQ_STANDING_KEY) { _, bundle ->
            bundle.getParcelable<DriverRoot.DriverStanding>(BUNDLE_STANDING_KEY)?.let { setElements(it) }
        }
    }

    private fun setElements(standing: DriverRoot.DriverStanding) {
       firstName.text = standing.Driver.givenName
        lastname.text = standing.Driver.familyName
        driverNumber.text = standing.Driver.permanentNumber
        team.text = standing.Constructors[0].name


    }


}