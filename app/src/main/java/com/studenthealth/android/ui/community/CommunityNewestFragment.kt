package com.studenthealth.android.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studenthealth.android.R

class CommunityNewestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_community_newest, container, false)
        val topicList = mutableListOf(CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？"),
            CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？", R.drawable.touxiang),
            CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？", R.drawable.touxiang, R.drawable.jiankang),
            CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？", R.drawable.touxiang, R.drawable.jiankang, R.drawable.jihua))
        val mCommunityNewestRecyclerViewAdapter = CommunityNewestRecyclerViewAdapter(activity!!, topicList)
        val mCommunityNewestRecyclerView = view.findViewById<RecyclerView>(R.id.communityNewestRecyclerView)
        mCommunityNewestRecyclerView.adapter = mCommunityNewestRecyclerViewAdapter
        val layoutManager = LinearLayoutManager(activity)
        mCommunityNewestRecyclerView.layoutManager = layoutManager

        return view
    }

}