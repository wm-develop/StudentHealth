package com.studenthealth.android.ui.individuality.myreply

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_reply.*

class ReplyActivity : AppCompatActivity() {

    lateinit var replyList: List<ReplyData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reply)
        replyToolbar.title = ""
        setSupportActionBar(replyToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val layoutManager = LinearLayoutManager(this)
        replyRecyclerView.layoutManager = layoutManager
        initReplyList()
        val replyRecyclerViewAdapter = ReplyRecyclerViewAdapter(this, replyList)
        replyRecyclerView.adapter = replyRecyclerViewAdapter
    }

    private fun initReplyList(){
        replyList = mutableListOf(ReplyData(R.drawable.touxiang, "用户名", "回复时间", "回复 XXXX：", "回复内容", "原始发帖人", "发帖主题/要回复的主题", "回复"),
            ReplyData(R.drawable.touxiang, "用户名", "回复时间", "回复 XXXX：", "回复内容", "原始发帖人", "发帖主题/要回复的主题", "回复"),
            ReplyData(R.drawable.touxiang, "用户名", "回复时间", "回复 XXXX：", "回复内容", "原始发帖人", "发帖主题/要回复的主题", "回复"),
            ReplyData(R.drawable.touxiang, "用户名", "回复时间", "回复 XXXX：", "回复内容", "原始发帖人", "发帖主题/要回复的主题", "回复"))
    }

}