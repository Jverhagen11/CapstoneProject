package com.example.capstoneproject.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.Api.RaceApi
import com.example.capstoneproject.Api.RaceApiService
import com.example.capstoneproject.Model.Race
import kotlinx.coroutines.withTimeout

class RaceRepository {

    private val raceApiService: RaceApiService = RaceApi.createApi()

    private val _race: MutableLiveData<Race> = MutableLiveData()

    val race: LiveData<Race>
        get() = _race

    suspend fun getRace()  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                raceApiService.getRace()
            }

            _race.value = result
        } catch (error: Throwable) {
            throw RaceError("Unable to refresh api", error)
        }
    }

    class RaceError(message: String, cause: Throwable) : Throwable(message, cause)

}