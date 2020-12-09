package com.example.capstoneproject.Api

import com.example.capstoneproject.Model.RaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RaceApiService {


    @GET("f1/current.json")
    suspend fun getMRData() : RaceResponse.Root

}
