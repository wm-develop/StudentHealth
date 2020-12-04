package com.studenthealth.android.ui.individuality

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studenthealth.android.R

class IndividualityTopLoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_individuality_top_login, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        topLoginLayout.setOnClickListener {
//            val intent = Intent(activity, LoginActivity::class.java)
//            startActivity(intent)
        }

}