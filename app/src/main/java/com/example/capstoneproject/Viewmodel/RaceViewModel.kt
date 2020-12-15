package com.example.capstoneproject.Viewmodel

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Model.Models.Racemodels.RaceX
import com.example.capstoneproject.Model.Models.Standings.Driver
import com.example.capstoneproject.Model.Models.Standings.DriverRoot
import com.example.capstoneproject.Model.Models.Standings.StandingsLists
import com.example.capstoneproject.Repository.RaceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RaceViewModel(application: Application) : AndroidViewModel(application) {


    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val raceRepository: RaceRepository = RaceRepository()

    val races: LiveData<List<RaceX>> = raceRepository.races
    val standings: LiveData<List<DriverRoot.DriverStanding>> = raceRepository.standings

    private val _errorText: MutableLiveData<String> = MutableLiveData()
    val errorText: LiveData<String> get() = _errorText



    @RequiresApi(Build.VERSION_CODES.N)
    fun getRaces() {
        mainScope.launch {
            try {
                raceRepository.getData()

            } catch (error: RaceRepository.RaceError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }
    fun getStandings() {
        mainScope.launch {
            try {
                raceRepository.getStanding()
            } catch (error: RaceRepository.RaceError) {
                _errorText.value = error.message
                Log.e("Race error", error.cause.toString())
            }
        }
    }

    private fun getPastRaces() {

    }





}