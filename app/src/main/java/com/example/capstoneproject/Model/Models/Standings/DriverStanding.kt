package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DriverStanding(
        @SerializedName("Constructors")val Constructors: List<Constructor>,
        @SerializedName("Driver")val Driver: Driver,
        @SerializedName("points")val points: String,
        @SerializedName("position")val position: String,
        @SerializedName("positionText")val positionText: String,
        @SerializedName("wins")val wins: String
) : Parcelable