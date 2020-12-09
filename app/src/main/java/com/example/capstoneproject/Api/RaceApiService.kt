package com.example.capstoneproject.Api

import com.example.capstoneproject.Model.Data
import retrofit2.http.GET

interface RaceApiService {

    @GET("f1/2020.json")
    suspend fun getData() : Data

}
