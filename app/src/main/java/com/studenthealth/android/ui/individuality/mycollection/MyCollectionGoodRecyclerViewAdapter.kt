package com.studenthealth.android.ui.individuality.mycollection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studenthealth.android.R

class MyCollectionGoodRecyclerViewAdapter(val context: Context, val goodList: List<MyCollectionGoodData>) : RecyclerView.Adapter<MyCollectionGoodRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.mycollectionGoodTitle)
        val image: ImageView = view.findViewById(R.id.mycollectionGoodImage)
        val time: TextView = view.findViewById(R.id.mycollectionGoodCollectTime)
    }

    override fun getItemCount() = goodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goodTopic = goodList[position]
        holder.title.text = goodTopic.title
        Glide.with(context).load(goodTopic.imageId).into(holder.image)
        holder.time.text = goodTopic.collectTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mycollection_good_item, parent, false)
        return ViewHolder(view)
    }

}