package com.example.capstoneproject.TabFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.RaceResponse
import com.example.capstoneproject.R
import com.example.capstoneproject.Viewmodel.RaceViewModel
import com.example.capstoneproject.databinding.FragmentUpcomingRaceItemBinding
import com.example.capstoneproject.databinding.FragmentUpcomingRacesBinding
import kotlinx.android.synthetic.main.fragment_upcoming_race_item.*
import kotlinx.android.synthetic.main.fragment_upcoming_races.*
import kotlinx.android.synthetic.main.fragment_upcoming_races.view.*

class UpcomingRacesFragment : Fragment() {

    private val raceViewModel: RaceViewModel by viewModels()
    private val races = arrayListOf<RaceResponse.Race>()
    private var raceAdapter: UpcomingRacesAdapter? = null

    private lateinit var binding: FragmentUpcomingRacesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpcomingRacesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        raceAdapter = UpcomingRacesAdapter(races)
        raceViewModel.getRace()
        observeRace()
        initRecyclerView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    private fun initRecyclerView() {
        upcomingRacesRV.apply {
            adapter = this@UpcomingRacesFragment.raceAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
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
            races.clear()
            races.addAll(it as Collection<RaceResponse.Race>)
            raceAdapter?.notifyDataSetChanged()
        })
        // Observe the error message.
        raceViewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}