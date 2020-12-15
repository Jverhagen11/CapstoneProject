package com.example.capstoneproject.Repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Api.RaceApi
import com.example.capstoneproject.Api.RaceApiService
import com.example.capstoneproject.Model.Models.Racemodels.MRData
import com.example.capstoneproject.Model.Models.Racemodels.RaceX
import com.example.capstoneproject.Model.Models.Standings.*
import kotlinx.coroutines.withTimeout

class RaceRepository {

    private val raceApiService: RaceApiService = RaceApi.createApi()

    private val _races: MutableLiveData<List<RaceX>> = MutableLiveData()
    val races: LiveData<List<RaceX>> get() = _races

    private val _standings: MutableLiveData<List<DriverRoot.DriverStanding>> = MutableLiveData()
    val standings: LiveData<List<DriverRoot.DriverStanding>> get() = _standings




    @RequiresApi(Build.VERSION_CODES.N)
    suspend fun getData() {
        try {
            //timeout the request after 5 seconds
            val races = withTimeout(5_000) {
                raceApiService.getData().MRData.RaceTable.races
            }
            races.sortedBy{it.date }
            _races.value = races

        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }

    suspend fun getStanding() {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                raceApiService.getStanding()
            }
            _standings.value = result.MRData.StandingsTable.StandingsLists[0].DriverStandings

        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }




    class RaceError(message: String, cause: Throwable) : Throwable(message, cause)

}