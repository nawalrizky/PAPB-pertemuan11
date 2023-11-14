package com.example.tugas_pertemuan11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tugas_pertemuan11.R
import com.example.tugas_pertemuan11.model.StationModel

class StationAdapter(private val context: Context, private val stationList: List<StationModel>) : BaseAdapter() {

    override fun getCount(): Int {
        return stationList.size
    }

    override fun getItem(position: Int): Any {
        return stationList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_station, parent, false)
            holder = ViewHolder()
            holder.codeTextView = view.findViewById(R.id.codeTextView)
            holder.nameTextView = view.findViewById(R.id.nameTextView)
            holder.cityTextView = view.findViewById(R.id.cityTextView)
            holder.cityNameTextView = view.findViewById(R.id.cityNameTextView)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val station = getItem(position) as StationModel
        holder.codeTextView.text = station.code
        holder.nameTextView.text = station.name
        holder.cityTextView.text = station.city
        holder.cityNameTextView.text = station.cityname

        return view!!
    }

    private class ViewHolder {
        lateinit var codeTextView: TextView
        lateinit var nameTextView: TextView
        lateinit var cityTextView: TextView
        lateinit var cityNameTextView: TextView
    }
}
