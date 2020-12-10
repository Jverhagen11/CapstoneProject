package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StandingsTable(
        @SerializedName("StandingsLists")val StandingsLists: List<StandingsLists>,
        @SerializedName("season")val season: String
)  : Parcelable