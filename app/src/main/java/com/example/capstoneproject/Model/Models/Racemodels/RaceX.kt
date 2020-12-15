package com.example.capstoneproject.Model.Models.Racemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RaceX(
        @SerializedName("Circuit") val Circuit: Circuit,
        @SerializedName("date") val date: String,
        @SerializedName("raceName") val raceName: String,
        @SerializedName("round") val round: String,
        @SerializedName("season")val season: String,
        @SerializedName("time")val time: String,
        @SerializedName("url")  val url: String
) : Parcelable