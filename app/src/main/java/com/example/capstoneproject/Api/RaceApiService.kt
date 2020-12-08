package com.example.capstoneproject.Api

import com.example.capstoneproject.Model.Race
import retrofit2.http.GET
import retrofit2.http.Query

interface RaceApiService {

    @GET("/2012")
    suspend fun getMovies(): Race

}