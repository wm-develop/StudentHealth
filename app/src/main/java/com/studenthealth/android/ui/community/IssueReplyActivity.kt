package com.studenthealth.android.ui.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_issue_reply.*

class IssueReplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_reply)
        issueReplyToolbar.title = ""
        setSupportActionBar(issueReplyToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.issue_topic_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.issue -> {
                //处理发表回复的相关逻辑
                finish()
            }
        }
        return true
    }
}