package com.studenthealth.android.ui.individuality

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import com.studenthealth.android.ui.individuality.mycollection.MyCollectionActivity
import kotlinx.android.synthetic.main.fragment_individuality_bottom.*

class IndividualityBottomFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_individuality_bottom, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        collection.setOnClickListener {
            val intent = Intent(activity, MyCollectionActivity::class.java)
            startActivity(intent)
        }
    }
}