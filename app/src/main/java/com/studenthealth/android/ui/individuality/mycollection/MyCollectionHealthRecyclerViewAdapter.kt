package com.studenthealth.android.ui.individuality.mycollection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.studenthealth.android.R

class MyCollectionHealthRecyclerViewAdapter(val context: Context, val healthList: List<MyCollectionHealthData>) : RecyclerView.Adapter<MyCollectionHealthRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.mycollectionHealthTitle)
        val content: TextView = view.findViewById(R.id.mycollectionHealthContent)
        val time: TextView = view.findViewById(R.id.mycollectionHealthCollectTime)
    }

    override fun getItemCount() = healthList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val healthTopic = healthList[position]
        holder.title.text = healthTopic.title
        holder.content.text = healthTopic.content
        holder.time.text = healthTopic.collectTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mycollection_health_item, parent, false)
        return ViewHolder(view)
    }

}