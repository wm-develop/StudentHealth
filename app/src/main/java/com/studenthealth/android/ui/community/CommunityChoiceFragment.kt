package com.studenthealth.android.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studenthealth.android.R

class CommunityChoiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_community_choice, container, false)
        val topicList = mutableListOf(CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？"),
            CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？", R.drawable.touxiang),
            CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？", R.drawable.touxiang, R.drawable.jiankang),
            CommunityTopicData(R.drawable.touxiang, "张三", "2020.10.1 15:40", "今天天气怎么样？", R.drawable.touxiang, R.drawable.jiankang, R.drawable.jihua))
        val mCommunityChoiceRecyclerViewAdapter = CommunityChoiceRecyclerViewAdapter(activity!!, topicList)
        val mCommunityChoiceRecyclerView = view.findViewById<RecyclerView>(R.id.communityChoiceRecyclerView)
        mCommunityChoiceRecyclerView.adapter = mCommunityChoiceRecyclerViewAdapter
        val layoutManager = LinearLayoutManager(activity)
        mCommunityChoiceRecyclerView.layoutManager = layoutManager

        return view
    }

}