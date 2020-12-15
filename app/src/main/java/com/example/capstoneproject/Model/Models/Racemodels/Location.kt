package com.example.capstoneproject.Model.Models.Racemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
        @SerializedName("country") val country: String,
        @SerializedName("lat") val lat: String,
        @SerializedName("locality") val locality: String,
        @SerializedName("long") val long: String
) : Parcelable