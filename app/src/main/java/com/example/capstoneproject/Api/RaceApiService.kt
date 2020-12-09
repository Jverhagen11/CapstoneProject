package com.example.capstoneproject.Api

import com.example.capstoneproject.Model.RaceResponse
import retrofit2.http.GET

interface RaceApiService {

    @GET("2020.json")
    suspend fun getRace(): RaceResponse.Root

    @GET("2020.json")
    suspend fun getMRData(): RaceResponse.MRData
}
