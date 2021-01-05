package com.example.capstoneproject

import android.R.drawable
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.capstoneproject.Model.Models.Standings.Driver
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

        btn_more.setBackgroundColor(getResources().getColor(R.color.purple_200))

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
        code.text = standing.Driver.code
        date.text =  standing.Driver.dateOfBirth
        dateTitle.text = getString(R.string.date)
        natioTitle.text = getString(R.string.Nationality)
        natio.text =   standing.Driver.nationality
        win.text =  standing.points
        winTitle.text = getString(R.string.Points)
        points.text =  standing.wins
        pointsTitle.text = getString(R.string.Wins)


        btn_more.setOnClickListener {

            val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(standing.Driver.url))
            context?.let { it1 -> ContextCompat.startActivity(it1, browserIntent, Bundle.EMPTY) }

        }

        val name = firstName.text

        if (name ==  getString(R.string.lewis)) {
            image.setImageResource(R.drawable.lewis)
        } else if( name ==  getString(R.string.Valtteri)) {
            image.setImageResource(R.drawable.valteri)
        } else if (name == getString(R.string.Max)) {
            image.setImageResource(R.drawable.max)
        } else if (name == getString(R.string.Sergio) ) {
            image.setImageResource(R.drawable.sergio)
        } else if (name == getString(R.string.Daniel)) {
            image.setImageResource(R.drawable.daniel)
        } else if (name == getString(R.string.Carlos)) {
            image.setImageResource(R.drawable.carlos)
        } else if (name == getString(R.string.Alexander)) {
            image.setImageResource(R.drawable.alexander)
        } else if (name == getString(R.string.Charles)) {
            image.setImageResource(R.drawable.charles)
        } else if (name == getString(R.string.Lando)) {
            image.setImageResource(R.drawable.lando)
        } else if (name == getString(R.string.Pierre)) {
            image.setImageResource(R.drawable.pierre)
        } else if (name == getString(R.string.Lance)) {
            image.setImageResource(R.drawable.lance)
        } else if (name == getString(R.string.Esteban)) {
            image.setImageResource(R.drawable.esteban)
        } else if (name == getString(R.string.Sebastian)) {
            image.setImageResource(R.drawable.sebastian)
        } else if (name == getString(R.string.Daniil)) {
            image.setImageResource(R.drawable.daniiel)
        } else if (name == getString(R.string.Nico)) {
            image.setImageResource(R.drawable.nico)
        } else if (name == getString(R.string.Kimi)) {
            image.setImageResource(R.drawable.kimi)
        } else if (name == getString(R.string.Antonio)) {
            image.setImageResource(R.drawable.antonio)
        } else if (name == getString(R.string.George)) {
            image.setImageResource(R.drawable.george)
        } else if (name == getString(R.string.Romain)) {
            image.setImageResource(R.drawable.romain)
        } else if (name == getString(R.string.Kevin)) {
            image.setImageResource(R.drawable.kevin)
        } else if (name == getString(R.string.Nicholas)) {
            image.setImageResource(R.drawable.nicholas)
        } else if (name == getString(R.string.Jack)) {
            image.setImageResource(R.drawable.jack)
        } else if (name == getString(R.string.Pietro)) {
            image.setImageResource(R.drawable.pietro)
        }

    }


}