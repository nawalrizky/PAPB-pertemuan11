package com.example.tugas_pertemuan11.network

import com.example.tugas_pertemuan11.model.StationModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("stations2")
    fun getStationData(): Call<List<StationModel>>
}
