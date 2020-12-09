package com.example.capstoneproject.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


class RaceResponse() {

    data class MRData(
        @SerializedName("raceTable") val raceTable: RaceTable
    )

    data class RaceTable(
        @SerializedName("races") val races: List<Races>
    )


    data class Root(
        @SerializedName("races") val races: List<Races>
    )

    @Parcelize
    data class Races(
        @SerializedName("circuit") val circuit: Circuit,
        @SerializedName("date") val date: String,
        @SerializedName("raceName") val raceName: String,
        @SerializedName("round") val round: String,
        @SerializedName("season") val season: String,
        @SerializedName("time") val time: String,
        @SerializedName("url") val url: String
    ) : Parcelable

    @Parcelize
    data class Circuit(
        @SerializedName("Location") val Location: Location,
        @SerializedName("circuitId") val circuitId: String,
        @SerializedName("circuitName") val circuitName: String,
        @SerializedName("url")val url: String
    ) : Parcelable

    @Parcelize
    data class Location(
        @SerializedName("country") val country: String,
        @SerializedName("lat") val lat: String,
        @SerializedName("locality") val locality: String,
        @SerializedName("long") val long: String
    ) : Parcelable


}