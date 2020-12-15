package com.example.capstoneproject.Model.Models.Racemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RaceTable(
        @SerializedName("Races") val races: List<RaceX>,
        @SerializedName("season") val season: String
) : Parcelable