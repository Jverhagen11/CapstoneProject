package com.example.capstoneproject.Api

import com.example.capstoneproject.Model.Models.Racemodels.RaceData
import com.example.capstoneproject.Model.Models.Standings.Driver
import com.example.capstoneproject.Model.Models.Standings.StandingData
import com.example.capstoneproject.Model.Models.Standings.StandingsLists
import retrofit2.http.GET

interface RaceApiService {

    @GET("f1/2020.json")
    suspend fun getData() : RaceData

    @GET("f1/current/driverStandings.json")
    suspend fun getStanding() : StandingData

}
