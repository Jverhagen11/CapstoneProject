package com.example.capstoneproject.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Api.RaceApi
import com.example.capstoneproject.Api.RaceApiService
import com.example.capstoneproject.Model.RaceResponse
import kotlinx.coroutines.withTimeout

class RaceRepository {

    private val raceApiService: RaceApiService = RaceApi.createApi()

    private val _races: MutableLiveData<List<RaceResponse.Races>> = MutableLiveData()
    val races: LiveData<List<RaceResponse.Races>> get() = _races

    private val _mdr: MutableLiveData<List<RaceResponse.Races>> = MutableLiveData()
    val mdr: MutableLiveData<List<RaceResponse.Races>> get() = _mdr


    suspend fun getRace()  {
        try {
            //timeout the request after 5 seconds

            val result = withTimeout(5_000) {
                raceApiService.getRace()
            }

            _races.value = result.races
        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }

    suspend fun getMRData()  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                raceApiService.getMRData()
            }
           _mdr.value = result.raceTable.races
        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }

    class RaceError(message: String, cause: Throwable) : Throwable(message, cause)

}