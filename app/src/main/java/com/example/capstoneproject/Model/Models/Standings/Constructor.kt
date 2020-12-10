package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Constructor(
        @SerializedName("constructorId") val constructorId: String,
        @SerializedName("name") val name: String,
        @SerializedName("nationality") val nationality: String,
        @SerializedName("url")val url: String
) : Parcelable