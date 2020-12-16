package com.studenthealth.android.ui.health

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.fragment_health.*

class HealthFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_health, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        everydaySportMaterialCardView.setOnClickListener {
            val intent = Intent(activity, EverydaySportActivity::class.java)
            startActivity(intent)
        }
        sportRecordMaterialCardView.setOnClickListener {
            val intent = Intent(activity, SportRecordActivity::class.java)
            startActivity(intent)
        }
        bodyWeightMaterialCardView.setOnClickListener {
            val intent = Intent(activity, BodyWeightActivity::class.java)
            startActivity(intent)
        }
    }
}