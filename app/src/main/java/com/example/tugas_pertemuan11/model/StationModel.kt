package com.example.tugas_pertemuan11.model

import com.google.gson.annotations.SerializedName

data class StationModel(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("city") val city: String,
    @SerializedName("cityname") val cityname: String,
)
