package com.example.capstoneproject.Api

import com.example.capstoneproject.Model.RaceResponse
import retrofit2.http.GET

interface RaceApiService {

    @GET("2012/races.json")
    suspend fun getRace(): RaceResponse.Root

    @GET("2012.json")
    suspend fun getMRData(): RaceResponse.MRData

}
