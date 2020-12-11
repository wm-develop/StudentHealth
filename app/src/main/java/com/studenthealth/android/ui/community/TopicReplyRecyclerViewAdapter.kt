package com.studenthealth.android.ui.community

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studenthealth.android.R
import de.hdodenhof.circleimageview.CircleImageView

class TopicReplyRecyclerViewAdapter(val context: Context, val replyList: List<TopicReplyData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val ONE_IMAGE_VIEW = 2
    private val TWO_IMAGE_VIEW = 3
    private val THREE_IMAGE_VIEW = 4
    private val NO_IMAGE_VIEW = 1

    inner class OneImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val replyUserImage: CircleImageView = view.findViewById(R.id.replyUserImage)
        val replyUserName: TextView = view.findViewById(R.id.replyUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val replyContent: TextView = view.findViewById(R.id.replyContent)
        val imageView1: ImageView = view.findViewById(R.id.imageView1)
    }

    inner class TwoImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val replyUserImage: CircleImageView = view.findViewById(R.id.replyUserImage)
        val replyUserName: TextView = view.findViewById(R.id.replyUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val replyContent: TextView = view.findViewById(R.id.replyContent)
        val imageView1: ImageView = view.findViewById(R.id.imageView1)
        val imageView2: ImageView = view.findViewById(R.id.imageView2)
    }

    inner class ThreeImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val replyUserImage: CircleImageView = view.findViewById(R.id.replyUserImage)
        val replyUserName: TextView = view.findViewById(R.id.replyUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val replyContent: TextView = view.findViewById(R.id.replyContent)
        val imageView1: ImageView = view.findViewById(R.id.imageView1)
        val imageView2: ImageView = view.findViewById(R.id.imageView2)
        val imageView3: ImageView = view.findViewById(R.id.imageView3)
    }

    inner class NoImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val replyUserImage: CircleImageView = view.findViewById(R.id.replyUserImage)
        val replyUserName: TextView = view.findViewById(R.id.replyUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val replyContent: TextView = view.findViewById(R.id.replyContent)
    }


    override fun getItemCount() = replyList.size

    override fun getItemViewType(position: Int): Int {
        if (replyList.get(position).image1Id == 0)
            return NO_IMAGE_VIEW
        else if (replyList.get(position).image2Id == 0 && replyList.get(position).image3Id == 0)
            return ONE_IMAGE_VIEW
        else if (replyList.get(position).image3Id == 0)
            return TWO_IMAGE_VIEW
        else
            return THREE_IMAGE_VIEW
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NoImageViewHolder) {
            val viewHolder = holder as NoImageViewHolder
            val reply = replyList[position]
            Glide.with(context).load(reply.replyUserImageId).into(viewHolder.replyUserImage)
            viewHolder.replyUserName.text = reply.replyUserName
            viewHolder.issueTime.text = reply.issueTime
            viewHolder.replyContent.text = reply.replyContent
        } else if (holder is OneImageViewHolder){
            val viewHolder = holder as OneImageViewHolder
            val reply = replyList[position]
            Glide.with(context).load(reply.replyUserImageId).into(viewHolder.replyUserImage)
            viewHolder.replyUserName.text = reply.replyUserName
            viewHolder.issueTime.text = reply.issueTime
            viewHolder.replyContent.text = reply.replyContent
            Glide.with(context).load(reply.image1Id).into(viewHolder.imageView1)
        } else if (holder is TwoImageViewHolder){
            val viewHolder = holder as TwoImageViewHolder
            val reply = replyList[position]
            Glide.with(context).load(reply.replyUserImageId).into(viewHolder.replyUserImage)
            viewHolder.replyUserName.text = reply.replyUserName
            viewHolder.issueTime.text = reply.issueTime
            viewHolder.replyContent.text = reply.replyContent
            Glide.with(context).load(reply.image1Id).into(viewHolder.imageView1)
            Glide.with(context).load(reply.image2Id).into(viewHolder.imageView2)
        } else {
            val viewHolder = holder as ThreeImageViewHolder
            val reply = replyList[position]
            Glide.with(context).load(reply.replyUserImageId).into(viewHolder.replyUserImage)
            viewHolder.replyUserName.text = reply.replyUserName
            viewHolder.issueTime.text = reply.issueTime
            viewHolder.replyContent.text = reply.replyContent
            Glide.with(context).load(reply.image1Id).into(viewHolder.imageView1)
            Glide.with(context).load(reply.image2Id).into(viewHolder.imageView2)
            Glide.with(context).load(reply.image3Id).into(viewHolder.imageView3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View

        if (viewType == NO_IMAGE_VIEW) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.reply_no_image_item, parent, false)
            val viewHolder = NoImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                //未来这里可以实现回复楼中楼逻辑
            }
            return viewHolder
        } else if (viewType == ONE_IMAGE_VIEW){
            view = LayoutInflater.from(parent.context).inflate(R.layout.reply_with_image_item, parent, false)
            val viewHolder = OneImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {

            }
            viewHolder.imageView1.setOnClickListener {
                //这里实现点击第一张图片放大查看的逻辑
            }
            return viewHolder
        } else if (viewType == TWO_IMAGE_VIEW){
            view = LayoutInflater.from(parent.context).inflate(R.layout.reply_with_image_item, parent, false)
            val viewHolder = TwoImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {

            }
            viewHolder.imageView1.setOnClickListener {
                //这里实现点击第一张图片放大查看的逻辑
            }
            viewHolder.imageView2.setOnClickListener {
                //这里实现点击第二张图片放大查看的逻辑
            }
            return viewHolder
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.reply_with_image_item, parent, false)
            val viewHolder = ThreeImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {

            }
            viewHolder.imageView1.setOnClickListener {
                //这里实现点击第一张图片放大查看的逻辑
            }
            viewHolder.imageView2.setOnClickListener {
                //这里实现点击第二张图片放大查看的逻辑
            }
            viewHolder.imageView3.setOnClickListener {
                //这里实现点击第三张图片放大查看的逻辑
            }
            return viewHolder
        }

    }

}