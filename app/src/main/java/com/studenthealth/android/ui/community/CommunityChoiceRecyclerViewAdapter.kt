package com.studenthealth.android.ui.community

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.studenthealth.android.R
import de.hdodenhof.circleimageview.CircleImageView

class CommunityChoiceRecyclerViewAdapter(val context: Context, val topicList: List<CommunityTopicData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val ONE_IMAGE_VIEW = 2
    private val TWO_IMAGE_VIEW = 3
    private val THREE_IMAGE_VIEW = 4
    private val NO_IMAGE_VIEW = 1

    inner class OneImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val communityUserImage: CircleImageView = view.findViewById(R.id.communityUserImage)
        val communityUserName: TextView = view.findViewById(R.id.communityUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val communityTitle: TextView = view.findViewById(R.id.communityTitle)
        val imageView1: ImageView = view.findViewById(R.id.imageView1)
        val replyButton: TextView = view.findViewById(R.id.replyButton)
        val shareButton: TextView = view.findViewById(R.id.shareButton)
    }

    inner class TwoImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val communityUserImage: CircleImageView = view.findViewById(R.id.communityUserImage)
        val communityUserName: TextView = view.findViewById(R.id.communityUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val communityTitle: TextView = view.findViewById(R.id.communityTitle)
        val imageView1: ImageView = view.findViewById(R.id.imageView1)
        val imageView2: ImageView = view.findViewById(R.id.imageView2)
        val replyButton: TextView = view.findViewById(R.id.replyButton)
        val shareButton: TextView = view.findViewById(R.id.shareButton)
    }

    inner class ThreeImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val communityUserImage: CircleImageView = view.findViewById(R.id.communityUserImage)
        val communityUserName: TextView = view.findViewById(R.id.communityUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val communityTitle: TextView = view.findViewById(R.id.communityTitle)
        val imageView1: ImageView = view.findViewById(R.id.imageView1)
        val imageView2: ImageView = view.findViewById(R.id.imageView2)
        val imageView3: ImageView = view.findViewById(R.id.imageView3)
        val replyButton: TextView = view.findViewById(R.id.replyButton)
        val shareButton: TextView = view.findViewById(R.id.shareButton)
    }

    inner class NoImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val communityUserImage: CircleImageView = view.findViewById(R.id.communityUserImage)
        val communityUserName: TextView = view.findViewById(R.id.communityUserName)
        val issueTime: TextView = view.findViewById(R.id.issueTime)
        val communityTitle: TextView = view.findViewById(R.id.communityTitle)
        val replyButton: TextView = view.findViewById(R.id.replyButton)
        val shareButton: TextView = view.findViewById(R.id.shareButton)
    }


    override fun getItemCount() = topicList.size

    override fun getItemViewType(position: Int): Int {
        if (topicList.get(position).image1Id == 0)
            return NO_IMAGE_VIEW
        else if (topicList.get(position).image2Id == 0 && topicList.get(position).image3Id == 0)
            return ONE_IMAGE_VIEW
        else if (topicList.get(position).image3Id == 0)
            return TWO_IMAGE_VIEW
        else
            return THREE_IMAGE_VIEW
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NoImageViewHolder) {
            val viewHolder = holder as NoImageViewHolder
            val topic = topicList[position]
            Glide.with(context).load(topic.communityUserImageId).into(viewHolder.communityUserImage)
            viewHolder.communityUserName.text = topic.communityUserName
            viewHolder.issueTime.text = topic.issueTime
            viewHolder.communityTitle.text = topic.communityTitle
            viewHolder.replyButton.text = topic.replyButton
            viewHolder.shareButton.text = topic.shareButton
        } else if (holder is OneImageViewHolder){
            val viewHolder = holder as OneImageViewHolder
            val topic = topicList[position]
            Glide.with(context).load(topic.communityUserImageId).into(viewHolder.communityUserImage)
            viewHolder.communityUserName.text = topic.communityUserName
            viewHolder.issueTime.text = topic.issueTime
            viewHolder.communityTitle.text = topic.communityTitle
            Glide.with(context).load(topic.image1Id).into(viewHolder.imageView1)
            viewHolder.replyButton.text = topic.replyButton
            viewHolder.shareButton.text = topic.shareButton
        } else if (holder is TwoImageViewHolder){
            val viewHolder = holder as TwoImageViewHolder
            val topic = topicList[position]
            Glide.with(context).load(topic.communityUserImageId).into(viewHolder.communityUserImage)
            viewHolder.communityUserName.text = topic.communityUserName
            viewHolder.issueTime.text = topic.issueTime
            viewHolder.communityTitle.text = topic.communityTitle
            Glide.with(context).load(topic.image1Id).into(viewHolder.imageView1)
            Glide.with(context).load(topic.image2Id).into(viewHolder.imageView2)
            viewHolder.replyButton.text = topic.replyButton
            viewHolder.shareButton.text = topic.shareButton
        } else {
            val viewHolder = holder as ThreeImageViewHolder
            val topic = topicList[position]
            Glide.with(context).load(topic.communityUserImageId).into(viewHolder.communityUserImage)
            viewHolder.communityUserName.text = topic.communityUserName
            viewHolder.issueTime.text = topic.issueTime
            viewHolder.communityTitle.text = topic.communityTitle
            Glide.with(context).load(topic.image1Id).into(viewHolder.imageView1)
            Glide.with(context).load(topic.image2Id).into(viewHolder.imageView2)
            Glide.with(context).load(topic.image3Id).into(viewHolder.imageView3)
            viewHolder.replyButton.text = topic.replyButton
            viewHolder.shareButton.text = topic.shareButton
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View

        if (viewType == NO_IMAGE_VIEW) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.community_no_image_item, parent, false)
            val viewHolder = NoImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val intent = Intent(parent.context, TopicActivity::class.java)
                parent.context.startActivity(intent)
            }
            viewHolder.shareButton.setOnClickListener {
                //这里实现分享按钮的相关逻辑
            }
            viewHolder.replyButton.setOnClickListener {
                //这里实现回复按钮的相关逻辑
            }
            return viewHolder
        } else if (viewType == ONE_IMAGE_VIEW){
            view = LayoutInflater.from(parent.context).inflate(R.layout.community_item, parent, false)
            val viewHolder = OneImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val intent = Intent(parent.context, TopicActivity::class.java)
                parent.context.startActivity(intent)
            }
            viewHolder.shareButton.setOnClickListener {
                //这里实现分享按钮的相关逻辑
            }
            viewHolder.replyButton.setOnClickListener {
                //这里实现回复按钮的相关逻辑
            }
            viewHolder.imageView1.setOnClickListener {
                //这里实现点击第一张图片放大查看的逻辑
            }
            return viewHolder
        } else if (viewType == TWO_IMAGE_VIEW){
            view = LayoutInflater.from(parent.context).inflate(R.layout.community_item, parent, false)
            val viewHolder = TwoImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val intent = Intent(parent.context, TopicActivity::class.java)
                parent.context.startActivity(intent)
            }
            viewHolder.shareButton.setOnClickListener {
                //这里实现分享按钮的相关逻辑
            }
            viewHolder.replyButton.setOnClickListener {
                //这里实现回复按钮的相关逻辑
            }
            viewHolder.imageView1.setOnClickListener {
                //这里实现点击第一张图片放大查看的逻辑
            }
            viewHolder.imageView2.setOnClickListener {
                //这里实现点击第二张图片放大查看的逻辑
            }
            return viewHolder
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.community_item, parent, false)
            val viewHolder = ThreeImageViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val intent = Intent(parent.context, TopicActivity::class.java)
                parent.context.startActivity(intent)
            }
            viewHolder.shareButton.setOnClickListener {
                //这里实现分享按钮的相关逻辑
            }
            viewHolder.replyButton.setOnClickListener {
                //这里实现回复按钮的相关逻辑
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