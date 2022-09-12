package com.example.covid19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DataAdapter(
    var dataList: ArrayList<Covid>,
    val inflater: LayoutInflater,
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView
        val today_confirmed: TextView
        val today_death: TextView

        init {
            date = itemView.findViewById(R.id.date)
            today_confirmed = itemView.findViewById(R.id.today_confirmed)
            today_death = itemView.findViewById(R.id.today_death)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.setText(dataList.get(position).date)
        holder.today_confirmed.setText(dataList.get(position).today_confirmed)
        holder.today_death.setText(dataList.get(position).today_death)
    }
}