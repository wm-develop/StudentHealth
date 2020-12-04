package com.studenthealth.android.ui.individuality

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import com.studenthealth.android.ui.individuality.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_individuality_top_unlogin.*

class IndividualityTopUnloginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_individuality_top_unlogin, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        topUnloginLayout.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
//        val constraintLayout: ConstraintLayout?= activity?.findViewById(R.id.topUnloginLayout)
//        if (constraintLayout != null) {
//            Toast.makeText(activity, "不为空", Toast.LENGTH_SHORT).show()
//            constraintLayout.setOnClickListener {
//                Toast.makeText(activity, "准备登陆", Toast.LENGTH_SHORT).show()
//            }
//        } else {
//            Toast.makeText(activity, "为空", Toast.LENGTH_SHORT).show()
//        }
    }

}