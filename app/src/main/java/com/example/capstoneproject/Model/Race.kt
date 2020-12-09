package com.example.capstoneproject.Model

import android.graphics.Movie
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


class RaceResponse() {

    data class MRD(
            @SerializedName("mrd") val Mrd: MRData
    )


    data class MRData(
            @SerializedName("raceTable") val raceTable: RaceTable,
            @SerializedName("limit") val limit: String,
            @SerializedName("offset") val offset: String,
            @SerializedName("series") val series: String,
            @SerializedName("total") val total: String,
            @SerializedName("url") val url: String,
            @SerializedName("xmlns") val xmlns: String
    )

    data class RaceTable(
            @SerializedName("races") val races: List<Races>,
            @SerializedName("season") val season: String
    )

    data class Root (
            @SerializedName("races") val races : List<Races>
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
            @SerializedName("url") val url: String
    ) : Parcelable

    @Parcelize
    data class Location(
            @SerializedName("country") val country: String,
            @SerializedName("lat") val lat: String,
            @SerializedName("locality") val locality: String,
            @SerializedName("long") val long: String
    ) : Parcelable


}