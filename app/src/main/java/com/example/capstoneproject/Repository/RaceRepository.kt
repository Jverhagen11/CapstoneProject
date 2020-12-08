package com.example.capstoneproject.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Api.RaceApi
import com.example.capstoneproject.Api.RaceApiService
import com.example.capstoneproject.Model.RaceResponse
import kotlinx.coroutines.withTimeout

class RaceRepository {



    private val raceApiService: RaceApiService = RaceApi.createApi()
    private val _races: MutableLiveData<List<RaceResponse.Race>> = MutableLiveData()
    val races: LiveData<List<RaceResponse.Race>> get() = _races

    suspend fun getRace()  {
        try {
            //timeout the request after 5 seconds
            val parsedRaceResponse  = withTimeout(5_000) {
                raceApiService.getRace()
            }

            _races.value = parsedRaceResponse.results

        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }

    class RaceError(message: String, cause: Throwable) : Throwable(message, cause)

}