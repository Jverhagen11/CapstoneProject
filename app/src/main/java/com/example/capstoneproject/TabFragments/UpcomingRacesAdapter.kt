package com.example.capstoneproject.TabFragments


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.RaceX
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentUpcomingRaceItemBinding

class UpcomingRacesAdapter(private val races: List<RaceX>) :
        RecyclerView.Adapter<UpcomingRacesAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         val binding = FragmentUpcomingRaceItemBinding.bind(itemView)

        fun dataBind(race: RaceX) {
            binding.raceName.text = race.raceName
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_upcoming_race_item, parent, false))
    }

    override fun getItemCount(): Int {
        return races.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(races[position])
    }


}

