package com.example.capstoneproject.Repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Api.RaceApi
import com.example.capstoneproject.Api.RaceApiService
import com.example.capstoneproject.Model.*
import kotlinx.coroutines.withTimeout

class RaceRepository {

    private val raceApiService: RaceApiService = RaceApi.createApi()

    private val _races: MutableLiveData<List<RaceX>> = MutableLiveData()
    val races: LiveData<List<RaceX>> get() = _races

    private val _data: MutableLiveData<MRData> = MutableLiveData()
    val data: MutableLiveData<MRData> get() = _data


    suspend fun getData() {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                raceApiService.getData()
            }
            _races.value = result.MRData.RaceTable.races

        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }

    class RaceError(message: String, cause: Throwable) : Throwable(message, cause)

}