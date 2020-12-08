package com.example.capstoneproject.TabFragments

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Race
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentUpcomingRaceItemBinding
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


class UpcomingRacesAdapter(private val races: List<Race>) :
        RecyclerView.Adapter<UpcomingRacesAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = FragmentUpcomingRaceItemBinding.bind(itemView)

//        @RequiresApi(Build.VERSION_CODES.O)
        fun dataBind(raceList: Race) {
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(races[position])
    }

    override fun getItemCount(): Int {
        return races.size
    }



}

