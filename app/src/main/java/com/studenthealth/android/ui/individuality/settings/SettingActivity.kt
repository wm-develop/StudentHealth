package com.studenthealth.android.ui.individuality.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        settingToolbar.title = ""
        setSupportActionBar(settingToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}