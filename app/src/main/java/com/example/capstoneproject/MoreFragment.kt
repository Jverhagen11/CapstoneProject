package com.example.capstoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.capstoneproject.databinding.FragmentMoreBinding
import com.google.android.material.navigation.NavigationView


class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        loadNavigationItems(binding.moreNavigation)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle(getString(R.string.More))
        activity?.actionBar?.setDisplayHomeAsUpEnabled(false)
    }


    private fun navigateToAboutApp() {
        findNavController().navigate(R.id.action_moreFragment_to_aboutAppFragment2)
    }

    private fun loadNavigationItems(navigationView: NavigationView) {

        var menu = navigationView.menu
        menu.findItem(R.id.OverDezeApp).setOnMenuItemClickListener {
            navigateToAboutApp()
            true
        }



    }


}