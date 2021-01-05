package com.example.capstoneproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.capstoneproject.TabFragments.PastRacesFragment
import com.example.capstoneproject.TabFragments.UpcomingRacesFragment
import com.example.capstoneproject.TabFragments.ViewPagerAdapter
import com.example.capstoneproject.Viewmodel.RaceViewModel
import kotlinx.android.synthetic.main.fragment_first.*

class RacingFragment : Fragment() {




    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle(getString(R.string.Racing))
        setUpTabs()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(UpcomingRacesFragment(), "Upcoming")
        adapter.addFragment(PastRacesFragment(), "Past")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

    }

