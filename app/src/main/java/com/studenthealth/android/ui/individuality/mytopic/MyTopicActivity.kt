package com.studenthealth.android.ui.individuality.mytopic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_my_topic.*

class MyTopicActivity : AppCompatActivity() {

    lateinit var topicList: List<MyTopicData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_topic)
        myTopicToolbar.title = ""
        setSupportActionBar(myTopicToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val layoutManager = LinearLayoutManager(this)
        myTopicRecyclerView.layoutManager = layoutManager
        initTopicList()
        val myTopicRecyclerViewAdapter = MyTopicRecyclerViewAdapter(this, topicList)
        myTopicRecyclerView.adapter = myTopicRecyclerViewAdapter
    }

    private fun initTopicList(){
        topicList = mutableListOf(MyTopicData("这是帖子的标题", "这是帖子的正文", "这是帖子的发表时间"), MyTopicData("这是帖子的标题", "这是帖子的正文", "这是帖子的发表时间"), MyTopicData("这是帖子的标题", "这是帖子的正文", "这是帖子的发表时间"), MyTopicData("这是帖子的标题", "这是帖子的正文", "这是帖子的发表时间"))
    }
}