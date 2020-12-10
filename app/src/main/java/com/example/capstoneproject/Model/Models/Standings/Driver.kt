package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Driver(
        @SerializedName("code") val code: String,
        @SerializedName("dateOfBirth") val dateOfBirth: String,
        @SerializedName("driverId")val driverId: String,
        @SerializedName("familyName")val familyName: String,
        @SerializedName("givenName")val givenName: String,
        @SerializedName("nationality")val nationality: String,
        @SerializedName("permanentNumber")val permanentNumber: String,
        @SerializedName("url")val url: String
) : Parcelable