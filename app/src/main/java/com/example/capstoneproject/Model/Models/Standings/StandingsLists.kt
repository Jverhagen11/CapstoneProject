package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StandingsLists(
        @SerializedName("DriverStandings")val DriverStandings: List<DriverStanding>,
        @SerializedName("round")val round: String,
        @SerializedName("season")val season: String
)  : Parcelable