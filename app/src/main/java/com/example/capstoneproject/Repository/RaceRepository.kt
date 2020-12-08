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

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val race: LiveData<Race>
        get() = _race

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun getRace()  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                raceApiService.getRace()
            }

            _race.value = result
        } catch (error: Throwable) {
            throw TriviaRefreshError("Unable to refresh api", error)
        }
    }

    class TriviaRefreshError(message: String, cause: Throwable) : Throwable(message, cause)

}