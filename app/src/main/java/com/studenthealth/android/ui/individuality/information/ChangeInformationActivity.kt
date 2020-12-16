package com.studenthealth.android.ui.individuality.information

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.Toast
import com.studenthealth.android.R
import com.studenthealth.android.util.LogUtil
import kotlinx.android.synthetic.main.activity_change_information.*

class ChangeInformationActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_information)
        editingInformationToolbar.title = ""
        setSupportActionBar(editingInformationToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setBirthdayMaterialButton.setOnClickListener {
            val year = birthYear.text.toString().toInt()
            val month = birthMonth.text.toString().toInt()
            val day = birthDay.text.toString().toInt()
            LogUtil.d("ChangeInformationActivity", "$year")
            LogUtil.d("ChangeInformationActivity", "$month")
            LogUtil.d("ChangeInformationActivity", "$day")
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                val datePickerDialog = DatePickerDialog(this, this, year, month, day)
                datePickerDialog.show()
            }
        }
        bindSchoolCardMaterialButton.setOnClickListener {
            val intent = Intent(this, BindSchoolCardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        birthYear.text = year.toString()
        birthMonth.text = month.toString()
        birthDay.text = dayOfMonth.toString()
        LogUtil.d("ChangeInformationActivity", "birthYear${birthYear.text}")
        LogUtil.d("ChangeInformationActivity", "birthMonth${birthMonth.text}")
        LogUtil.d("ChangeInformationActivity", "birthDay${birthDay.text}")
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