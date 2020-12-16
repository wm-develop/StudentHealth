package com.studenthealth.android.ui.health

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studenthealth.android.R

class SportRecordRecyclerViewAdapter(val context: Context, val sportRecordList: List<SportRecordData>) : RecyclerView.Adapter<SportRecordRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sportTypeImageView: ImageView = view.findViewById(R.id.sportTypeImageView)
        val sportContent: TextView = view.findViewById(R.id.sportContent)
        val sportTime: TextView = view.findViewById(R.id.sportTime)
    }

    override fun getItemCount() = sportRecordList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport = sportRecordList[position]
        Glide.with(context).load(sport.sportTypeImageId).into(holder.sportTypeImageView)
        holder.sportContent.text = sport.sportContent
        holder.sportTime.text = sport.sportTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sport_record_item, parent, false)
        return ViewHolder(view)
    }

}