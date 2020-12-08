package com.example.capstoneproject.TabFragments


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.RaceResponse
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentUpcomingRaceItemBinding


class UpcomingRacesAdapter(private val races: List<RaceResponse.Race>) :
        RecyclerView.Adapter<UpcomingRacesAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = FragmentUpcomingRaceItemBinding.bind(itemView)

        fun dataBind(raceList: RaceResponse.Race) {
            binding.raceName.text = raceList.raceName

        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.fragment_upcoming_race_item, parent, false)
        )
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.dataBind(races[position])
    }

    override fun getItemCount(): Int {
        return races.size
    }



}

