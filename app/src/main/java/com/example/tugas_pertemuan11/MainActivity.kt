package com.example.tugas_pertemuan11

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas_pertemuan11.databinding.ActivityMainBinding
import com.example.tugas_pertemuan11.model.StationModel
import com.example.tugas_pertemuan11.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listView = binding.listView

        fetchData()
    }

    private fun fetchData() {
        val apiService = ApiClient.getInstance().getStationData()

        apiService.enqueue(object : Callback<List<StationModel>> {
            override fun onResponse(
                call: Call<List<StationModel>>,
                response: Response<List<StationModel>>
            ) {
                if (response.isSuccessful) {
                    val stationList = response.body()!!
                    val adapter = StationAdapter(this@MainActivity, stationList)
                    listView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<StationModel>>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ${t.message}")
            }
        })
    }
}
