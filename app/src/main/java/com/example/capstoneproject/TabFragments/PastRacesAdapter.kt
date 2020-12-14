package com.example.capstoneproject.TabFragments

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Models.Racemodels.RaceX
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentPastRacesItemBinding
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class PastRacesAdapter(private val pastRaces: List<RaceX>)
    : RecyclerView.Adapter<PastRacesAdapter.ViewHolder>() {

        private lateinit var context: Context

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val binding = FragmentPastRacesItemBinding.bind(itemView)

            @RequiresApi(Build.VERSION_CODES.O)
            fun dataBind(race: RaceX) {
                binding.raceName.text = race.raceName
                binding.round.text = "Round " + race.round
//                binding.time.text = race.time.format(DateTimeFormatter.ofPattern("HH:mm"))
                binding.location.text = race.Circuit.Location.locality
                binding.date.text = race.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
            }
        }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_past_races_item, parent, false))
    }

    override fun getItemCount(): Int {
        return pastRaces.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(pastRaces[position])
    }

    }
