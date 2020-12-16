package com.studenthealth.android.ui.individuality.information


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_bind_school_card.*

class BindSchoolCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_school_card)
        bindSchoolCardToolbar.title = ""
        setSupportActionBar(bindSchoolCardToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}