package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MRData(
        @SerializedName("StandingsTable") val StandingsTable: StandingsTable,
        @SerializedName("limit") val limit: String,
        @SerializedName("offset") val offset: String,
        @SerializedName("series") val series: String,
        @SerializedName("total") val total: String,
        @SerializedName("url") val url: String,
        @SerializedName("xmlns") val xmlns: String
)  : Parcelable