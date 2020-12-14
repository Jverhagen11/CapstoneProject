package com.example.capstoneproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.Model.Models.Standings.Driver
import com.example.capstoneproject.Model.Models.Standings.DriverStanding
import com.example.capstoneproject.Model.Models.Standings.StandingsLists
import com.example.capstoneproject.Viewmodel.RaceViewModel
import kotlinx.android.synthetic.main.fragment_standings.*
import kotlinx.android.synthetic.main.fragment_upcoming_races.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class StandingsFragment : Fragment() {


    private val standings = arrayListOf<DriverStanding>()
    private val standingsAdapter = StandingsAdapter(standings)
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