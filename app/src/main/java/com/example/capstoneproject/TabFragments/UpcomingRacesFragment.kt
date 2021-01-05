package com.example.capstoneproject.TabFragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.Model.Models.Racemodels.RaceX
import com.example.capstoneproject.R
import com.example.capstoneproject.Viewmodel.RaceViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_upcoming_races.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UpcomingRacesFragment : Fragment() {

    private val races = arrayListOf<RaceX>()
    private val filterRaces = arrayListOf<RaceX>()
    private val raceAdapter = UpcomingRacesAdapter(races)
    private val raceViewModel: RaceViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming_races, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        raceViewModel.getRaces()
        observeRace()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        upcomingRacesRV.apply {
            adapter = raceAdapter
            layoutManager = GridLayoutManager(context, 1)
            addItemDecoration(
                    DividerItemDecoration(
                            context,
                            DividerItemDecoration.VERTICAL
                    )
            )
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun observeRace() {
        raceViewModel.races.observe(viewLifecycleOwner, Observer {

            races.clear()
            filterRaces.addAll(it)

            for (race in filterRaces){

                val date = LocalDate.parse(race.date, DateTimeFormatter.ISO_DATE)
                val raceDate = LocalDate.now()

                if(date > raceDate) {
                    races.add(race)
                }
            }

            if (races.isEmpty()){
                Snackbar.make(requireView(), "There are no upcoming races", Snackbar.LENGTH_SHORT).show()
            }

            raceAdapter.notifyDataSetChanged()
            })
        // Observe the error message.
        raceViewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}