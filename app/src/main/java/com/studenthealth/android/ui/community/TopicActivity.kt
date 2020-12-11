package com.studenthealth.android.ui.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_topic.*

class TopicActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: TopicReplyRecyclerViewAdapter

    private val replyList = mutableListOf(TopicReplyData(R.drawable.touxiang, "张三", "2020.11.19", "这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复"),
        TopicReplyData(R.drawable.touxiang, "张三", "2020.11.19", "这里是我的回复这里是我的回复这里是我的回复这里是我的回复", R.drawable.fanhui),
        TopicReplyData(R.drawable.touxiang, "张三", "2020.11.19", "这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复", R.drawable.fanhui, R.drawable.wode),
        TopicReplyData(R.drawable.touxiang, "张三", "2020.11.19", "这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复这里是我的回复", R.drawable.fanhui, R.drawable.wode, R.drawable.mima))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)
        topicToolbar.title = ""
        setSupportActionBar(topicToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //全部回复
        layoutManager = LinearLayoutManager(this)
        topicReplyRecyclerView.layoutManager = layoutManager
        adapter = TopicReplyRecyclerViewAdapter(this, replyList)
        topicReplyRecyclerView.adapter = adapter

        topicChipGroup.setOnCheckedChangeListener { group, checkedId ->
            var hintStr = ""
            when(checkedId) {
                R.id.allReplyChip -> {
                    //全部回复
                    layoutManager = LinearLayoutManager(this)
                    topicReplyRecyclerView.layoutManager = layoutManager
                    adapter = TopicReplyRecyclerViewAdapter(this, replyList)
                    topicReplyRecyclerView.adapter = adapter
                }
                R.id.onlyTSChip -> {
                    //只看楼主
                    layoutManager = LinearLayoutManager(this)
                    topicReplyRecyclerView.layoutManager = layoutManager
                    adapter = TopicReplyRecyclerViewAdapter(this, replyList)
                    topicReplyRecyclerView.adapter = adapter
                }
                else -> allReplyChip.isChecked = true
            }
        }

        issueReplyFloatingActionButton.setOnClickListener {
            val intent = Intent(this, IssueReplyActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
    }
}