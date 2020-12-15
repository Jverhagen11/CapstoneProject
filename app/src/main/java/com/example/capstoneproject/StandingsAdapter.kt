package com.example.capstoneproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Models.Standings.DriverRoot
import com.example.capstoneproject.Model.Models.Standings.StandingsLists
import com.example.capstoneproject.databinding.FragmentPastRacesItemBinding
import com.example.capstoneproject.databinding.FragmentStandingItemBinding

class StandingsAdapter(private val standings: ArrayList<DriverRoot.DriverStanding>, private val onClick: (DriverRoot.DriverStanding) -> Unit)

    : RecyclerView.Adapter<StandingsAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val binding = FragmentStandingItemBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                onClick(standings[adapterPosition])
            }
        }

        fun dataBind( driver: DriverRoot.DriverStanding) {
            binding.position.text = driver.position
            binding.driverName.text = driver.Driver.givenName + " " +  driver.Driver.familyName
            binding.points.text = driver.points + " PTS"
            binding.team.text = driver.Constructors[0].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_standing_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(standings[position])
    }

    override fun getItemCount(): Int {
      return standings.size
    }

}