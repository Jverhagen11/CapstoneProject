package com.example.capstoneproject.TabFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.Model.RaceX
import com.example.capstoneproject.R
import com.example.capstoneproject.Viewmodel.RaceViewModel
import kotlinx.android.synthetic.main.fragment_upcoming_races.*

class UpcomingRacesFragment : Fragment() {

    private val races = arrayListOf<RaceX>()
    private val raceAdapter = UpcomingRacesAdapter(races)
    private val raceViewModel: RaceViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_races, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        raceViewModel.getData()
        observeRace()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        upcomingRacesRV.apply {
            adapter = raceAdapter
            layoutManager = GridLayoutManager(context, 1)
        }
    }

    private fun observeRace() {
        raceViewModel.races.observe(viewLifecycleOwner, Observer {
            races.clear()
            races.addAll(it)
            raceAdapter.notifyDataSetChanged()
            })
        // Observe the error message.
        raceViewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}