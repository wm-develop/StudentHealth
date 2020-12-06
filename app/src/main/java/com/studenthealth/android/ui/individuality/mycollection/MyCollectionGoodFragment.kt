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

class MyCollectionGoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mycollection_good, container, false)
        val goodList = mutableListOf(MyCollectionGoodData("123", R.drawable.jiankang, "789"), MyCollectionGoodData("321", R.drawable.duanxin, "987"), MyCollectionGoodData("987", R.drawable.huifu, "321"), MyCollectionGoodData("测试标题", R.drawable.jihua, "测试时间"))
        val myCollectionGoodRecyclerViewAdapter = MyCollectionGoodRecyclerViewAdapter(activity!!, goodList)
        val mMycollectionGoodRecyclerView = view.findViewById<RecyclerView>(R.id.mycollectionGoodRecyclerView)
        mMycollectionGoodRecyclerView.adapter = myCollectionGoodRecyclerViewAdapter
        val layoutManager = LinearLayoutManager(activity)
        mMycollectionGoodRecyclerView.layoutManager = layoutManager

        return view
    }

}