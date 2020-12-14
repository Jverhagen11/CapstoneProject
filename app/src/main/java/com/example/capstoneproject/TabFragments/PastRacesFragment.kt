package com.example.capstoneproject.TabFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.capstoneproject.Model.Models.Racemodels.RaceX
import com.example.capstoneproject.R
import com.example.capstoneproject.Viewmodel.RaceViewModel
import kotlinx.android.synthetic.main.fragment_past_races.*

class PastRacesFragment : Fragment() {

    private val pastRaces = arrayListOf<RaceX>()
    private val pastRaceAdapter = PastRacesAdapter(pastRaces)
    private val raceViewModel: RaceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past_races, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        raceViewModel.getRaces()
        observeRace()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        pastRacesRV.apply {
            adapter = pastRaceAdapter
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
        raceViewModel.races.observe(viewLifecycleOwner, Observer {
            pastRaces.clear()
            pastRaces.addAll(it)
            pastRaceAdapter.notifyDataSetChanged()
        })
        // Observe the error message.
        raceViewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}