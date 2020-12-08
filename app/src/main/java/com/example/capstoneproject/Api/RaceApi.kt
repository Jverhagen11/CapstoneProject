package com.example.capstoneproject.Api


import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RaceApi {

    companion object {
        // The base url off the api.
        private const val baseUrl = "https://ergast.com/api/f1"

        /**
         * @return [RaceApiService] The service class off the retrofit client.
         */
        fun createApi(): RaceApiService {
            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

            // Create the Retrofit instance
            val triviaApi = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            // Return the Retrofit NumbersApiService
            return triviaApi.create(RaceApiService::class.java)
        }
    }
}