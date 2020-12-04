package com.studenthealth.android.ui.individuality.information

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_change_information.*

class ChangeInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_information)
        editingInformationToolbar.title = ""
        setSupportActionBar(editingInformationToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editing_information_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.save_information -> Toast.makeText(this, "你点击了保存按钮", Toast.LENGTH_SHORT).show()
            android.R.id.home -> finish()
        }
        return true
    }
}