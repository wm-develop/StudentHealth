package com.studenthealth.android.ui.individuality.mycollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studenthealth.android.R

class MyCollectionTopicFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mycollection_topic, container, false)
        val topicList = mutableListOf(MyCollectionTopicData("123", "456", "789"), MyCollectionTopicData("321", "654", "987"), MyCollectionTopicData("987", "654", "321"), MyCollectionTopicData("测试标题", "测试正文", "测试时间"))
        val myCollectionTopicRecyclerViewAdapter = MyCollectionTopicRecyclerViewAdapter(activity!!, topicList)
        val mMycollectionTopicRecyclerView = view.findViewById<RecyclerView>(R.id.mycollectionTopicRecyclerView)
        mMycollectionTopicRecyclerView.adapter = myCollectionTopicRecyclerViewAdapter
        val layoutManager = LinearLayoutManager(activity)
        mMycollectionTopicRecyclerView.layoutManager = layoutManager

        return view
    }

}