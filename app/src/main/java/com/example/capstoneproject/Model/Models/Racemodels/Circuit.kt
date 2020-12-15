package com.example.capstoneproject.Model.Models.Racemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Circuit(
        @SerializedName("Location") val Location: Location,
        @SerializedName("circuitId") val circuitId: String,
        @SerializedName("circuitName") val circuitName: String,
        @SerializedName("url") val url: String
) : Parcelable