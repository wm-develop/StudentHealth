package com.studenthealth.android.ui.individuality.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.fragment_find_password_reset_success.*

class FindPasswordResetSuccessFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_find_password_reset_success, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backToLoginMaterialButton.setOnClickListener {
            activity?.finish()
        }
    }
}