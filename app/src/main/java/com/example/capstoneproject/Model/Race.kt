package com.example.capstoneproject.Model

import android.graphics.Movie
import com.google.gson.annotations.SerializedName


class RaceResponse() {

    data class Root(
        @SerializedName("results") val results: List<Race>

    )

    data class Race(
        @SerializedName("raceName") var raceName: String

    )
}