package com.studenthealth.android.ui.individuality.mycollection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.studenthealth.android.R

class MyCollectionTopicRecyclerViewAdapter(val context: Context, val topicList: List<MyCollectionTopicData>) : RecyclerView.Adapter<MyCollectionTopicRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.mycollectionTopicTitle)
        val content: TextView = view.findViewById(R.id.mycollectionTopicContent)
        val time: TextView = view.findViewById(R.id.mycollectionTopicCollectTime)
    }

    override fun getItemCount() = topicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val topic = topicList[position]
        holder.title.text = topic.title
        holder.content.text = topic.content
        holder.time.text = topic.collectTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mycollection_topic_item, parent, false)
        return ViewHolder(view)
    }

}