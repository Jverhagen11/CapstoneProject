package com.example.capstoneproject.Model.Models.Standings

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


class DriverRoot{

    @Parcelize
    data class DriverStanding(
            @SerializedName("Constructors")val Constructors: List<Constructor>,
            @SerializedName("Driver")val Driver: Driver,
            @SerializedName("points")val points: String,
            @SerializedName("position")val position: String,
            @SerializedName("positionText")val positionText: String,
            @SerializedName("wins")val wins: String,
            @SerializedName("image")val image: String
    
    ) : Parcelable {

        fun getDriverImageUrl(driver: DriverStanding): String {
            return "https://www.formula1.com/content/fom-website/en/drivers/%s/_jcr_content/image.img.1920.medium.jpg/1602844295176.jpg".format(driver.Driver.givenName + driver.Driver.familyName)
        }
    }



}



