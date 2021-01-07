package com.example.capstoneproject.Standing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.Model.Models.Standings.*
import com.example.capstoneproject.R
import com.example.capstoneproject.Viewmodel.RaceViewModel
import kotlinx.android.synthetic.main.fragment_standings.*

const val BUNDLE_STANDING_KEY = "bundle_standing_key"
const val REQ_STANDING_KEY = "req_standing_key"

class StandingsFragment : Fragment() {


    private val standings = arrayListOf<DriverRoot.DriverStanding>()
    private val standingsAdapter = StandingsAdapter(standings, ::onStandingClick)
    private val raceViewModel: RaceViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle("Standings")
        raceViewModel.getStandings()
        observeRace()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        standingsrv.apply {
            adapter = standingsAdapter
            layoutManager = GridLayoutManager(context, 1)
            addItemDecoration(
                    DividerItemDecoration(
                            context,
                            DividerItemDecoration.VERTICAL
                    )
            )
        }

    }

    private fun onStandingClick(standing: DriverRoot.DriverStanding) {

        setFragmentResult(REQ_STANDING_KEY, bundleOf(Pair(BUNDLE_STANDING_KEY, standing)))
        findNavController().navigate(R.id.action_secondFragment_to_overviewStandingFragment)


    }

    private fun observeRace() {
        raceViewModel.standings.observe(viewLifecycleOwner, Observer {
            standings.clear()
            standings.addAll(it)
            standingsAdapter.notifyDataSetChanged()
        })
        // Observe the error message.
        raceViewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}