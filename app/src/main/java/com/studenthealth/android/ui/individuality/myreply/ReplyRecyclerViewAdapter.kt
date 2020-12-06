package com.studenthealth.android.ui.individuality.myreply

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studenthealth.android.R
import de.hdodenhof.circleimageview.CircleImageView

class ReplyRecyclerViewAdapter(val context: Context, val replyList: List<ReplyData>) : RecyclerView.Adapter<ReplyRecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val replyUserImage: CircleImageView = view.findViewById(R.id.replyUserImage)
        val replyUserName: TextView = view.findViewById(R.id.replyUserName)
        val replyTime: TextView = view.findViewById(R.id.replyTime)
        val replyToUserName: TextView = view.findViewById(R.id.replyToUserName)
        val replyToContent: TextView = view.findViewById(R.id.replyToContent)
        val originUserName: TextView = view.findViewById(R.id.originUserName)
        val originTitle: TextView = view.findViewById(R.id.originTitle)
        val replyButton: TextView = view.findViewById(R.id.replyButton)
    }

    override fun getItemCount() = replyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reply = replyList[position]
        Glide.with(context).load(reply.replyUserImageId).into(holder.replyUserImage)
        holder.replyUserName.text = reply.replyUserName
        holder.replyTime.text = reply.replyTime
        holder.replyToUserName.text = reply.replyToUserName
        holder.replyToContent.text = reply.replyToContent
        holder.originUserName.text = reply.originUserName
        holder.originTitle.text = reply.originTitle
        holder.replyButton.text = reply.replyButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.reply_item, parent, false)
        return ViewHolder(view)
    }

}