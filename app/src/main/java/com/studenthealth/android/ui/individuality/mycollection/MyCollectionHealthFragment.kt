package com.studenthealth.android.ui.individuality.mycollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studenthealth.android.R
import com.studenthealth.android.util.LogUtil

class MyCollectionHealthFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mycollection_health, container, false)
        val healthList = mutableListOf(MyCollectionHealthData("123", "456", "789"), MyCollectionHealthData("321", "654", "987"), MyCollectionHealthData("987", "654", "321"), MyCollectionHealthData("测试标题", "测试正文", "测试时间"))
        val myCollectionHealthRecyclerViewAdapter = MyCollectionHealthRecyclerViewAdapter(activity!!, healthList)
//        if (myCollectionHealthRecyclerViewAdapter == null) LogUtil.d("MyCollectionHealthFragment", "myCollectionHealthRecyclerViewAdapter为空，原因是没有获取到Context")
//        if (mycollectionHealthRecyclerView == null) LogUtil.d("MyCollectionHealthFragment", "kotlin语法糖无法在这里获取到Recycler的实例")
        val mMycollectionHealthRecyclerView = view.findViewById<RecyclerView>(R.id.mycollectionHealthRecyclerView)
//        if (mMycollectionHealthRecyclerView == null) LogUtil.d("MyCollectionHealthFragment", "通过findViewById仍然获取不到RecyclerView的实例")
        mMycollectionHealthRecyclerView.adapter = myCollectionHealthRecyclerViewAdapter
        val layoutManager = LinearLayoutManager(activity)
//        if (layoutManager == null) LogUtil.d("MyCollectionHealthFragment", "layoutManager为空")
        mMycollectionHealthRecyclerView.layoutManager = layoutManager

        return view
    }

}