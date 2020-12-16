package com.studenthealth.android.ui.health

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_sport_record.*

class SportRecordActivity : AppCompatActivity() {

    private val sportRecordList = mutableListOf(SportRecordData(R.drawable.buxing, "健走0.80公里", "12月4日"),
            SportRecordData(R.drawable.buxing, "健走1.56公里", "11月30日"),
            SportRecordData(R.drawable.buxing, "健走2.41公里", "11月24日"),
            SportRecordData(R.drawable.paobu, "体能跑步3.58公里", "11月17日"),
            SportRecordData(R.drawable.buxing, "健走0.56公里", "11月8日"),
            SportRecordData(R.drawable.qixing, "户外骑行6.98公里", "11月2日"),
            SportRecordData(R.drawable.paobu, "体能跑步2.96公里", "10月29日"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport_record)
        sportRecordToolbar.title = ""
        setSupportActionBar(sportRecordToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val layoutManager = LinearLayoutManager(this)
        sportRecordRecyclerView.layoutManager = layoutManager
        val sportRecyclerViewAdapter = SportRecordRecyclerViewAdapter(this, sportRecordList)
        sportRecordRecyclerView.adapter = sportRecyclerViewAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}